/*
 * This file is written by reyoung, reyoung@126.com.
 */
package Network;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapAddr;
import org.jnetpcap.PcapIf;
import org.jnetpcap.PcapSockAddr;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Http;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;

/**
 *
 * @author Reyoung
 */
public class ListenThread extends Thread {

    public ListenThread(PcapIf dev, INetwork nw) {
        assert (dev != null);
        assert (nw != null);
        m_dev = dev;
        m_network = nw;
    }

    @Override
    public void run() {
        StringBuilder errorbuffer = new StringBuilder();
        Pcap cap = Pcap.openLive(m_dev.getName(),
                2048,
                Pcap.MODE_PROMISCUOUS,
                1000 * 30,
                errorbuffer);
        assert (cap != null);
        PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

            public void nextPacket(PcapPacket packet, String user) {
                Ip4 ip = new Ip4();
                long t = packet.getCaptureHeader().timestampInMillis();
                Tcp tcp = new Tcp();
                Udp udp = new Udp();
                int s = 0;
                int d = 0;
                int sp = 0;
                int tp = 0;
                int okcount = 0;
                int flag = 0;
                Date arriveTime = new Date(t);
                if (packet.hasHeader(ip, 0)) {
                    s = ip.sourceToInt();
                    d = ip.destinationToInt();
                    ++okcount;
                    // Expect DIP = ca710f02 or ca710f01 , as 202.113.15.1 or 202.113.15.2
                }
                if (packet.hasHeader(tcp)) {
                    sp = tcp.source();
                    tp = tcp.destination();
                    flag |= IPacket.PacketFlag_TCP;
                    ++okcount;
                }
                if (packet.hasHeader(udp)) {
                    sp = udp.source();
                    tp = udp.destination();
                    flag |= IPacket.PacketFlag_UDP;
                    ++okcount;
                }
                if (packet.hasHeader(Http.ID)) {
                    flag |= IPacket.PacketFlag_HTTP;
                }
                if (packet.hasHeader(Ethernet.ID)) {
                    flag |= IPacket.PacketFlag_Ethernet;
                }

                if (okcount != 2) {
//                    System.out.printf("No Tcp/Ip Capture\n");
                } else {
                    Packet p = new Packet();
                    p.DIP = s;
                    p.SIP = d;
                    p.DPort = sp;
                    p.SPort = tp;
                    p.PackLen = packet.getCaptureHeader().caplen();
                    p.RecvTime = arriveTime;
                    if (s == GetDeviceIpInt(m_dev) || d == GetDeviceIpInt(m_dev)) {
                        p.IsUpdate = (GetDeviceIpInt(m_dev) != s); //! TODO upload download refine.
                        p.PacketFlag = flag;
                        synchronized (ListenThread.this) {
                            List<IPacketListener> listeners = m_network.getPacketListeners();
                            ListIterator<IPacketListener> it = listeners.listIterator();
                            while (it.hasNext()) {
                                it.next().onPacketRecv(p);
                            }
                        }
                    }
                }
            }
        };
        while (true) {
            cap.loop(10, jpacketHandler, m_dev.getDescription());
        }
    }

    static private int GetDeviceIpInt(PcapIf dev) {
        List<PcapAddr> addrs = dev.getAddresses();
        ListIterator<PcapAddr> it = addrs.listIterator();
        PcapAddr ipv4 = null;
        while (it.hasNext()) {
            PcapAddr temp = it.next();
            if (temp.getAddr().getFamily() == PcapSockAddr.AF_INET) {
                ipv4 = temp;
            }
        }
        if (ipv4 == null) {
            return -1;
        } else {
            byte[] ipv4byte = ipv4.getAddr().getData();
            assert (ipv4byte.length == 4);
            int retv = 0;
            retv = ((ipv4byte[0] << 24) & 0xff000000)
                    | ((ipv4byte[1] << 16) & 0x00ff0000)
                    | ((ipv4byte[2] << 8) & 0x0000ff00)
                    | (ipv4byte[3] & 0x000000ff);
            return retv;
        }
    }
    private PcapIf m_dev;
    private INetwork m_network;
}
