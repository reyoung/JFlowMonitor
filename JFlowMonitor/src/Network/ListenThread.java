/*
 * This file is written by reyoung, reyoung@126.com.
 */
package Network;

import java.util.Date;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Ip4;
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
                    ++okcount;
                }
                if (packet.hasHeader(udp)) {
                    sp = udp.source();
                    tp = udp.destination();
                    ++okcount;
                }
                if (okcount != 2) {
                    System.out.printf("No Tcp/Ip Capture\n");
                } else {
                    System.out.printf("SIP %d:%d DIP %d:%d Arrive Time: %s\n", s, sp, d, tp, arriveTime.toString());
                }
            }
        };
        cap.loop(10, jpacketHandler, m_dev.getDescription());
    }
    private PcapIf m_dev;
    private INetwork m_network;
}
