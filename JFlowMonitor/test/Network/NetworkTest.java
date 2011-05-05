/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jnetpcap.*;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;

/**
 *
 * @author Reyoung
 */
public class NetworkTest {
    static private ArrayList<PcapIf>  devices;
    static  private StringBuilder      errorbuffer;
    static private Pcap cap;
    public NetworkTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        devices = new ArrayList<PcapIf>();
        errorbuffer = new StringBuilder();
        System.out.printf("List Device Test-----------------\n");
        
        int ok = Pcap.findAllDevs(devices, errorbuffer);
        assertEquals(ok, 0);
        assertNotSame(devices.size(),0);
        for(int i=0;i<devices.size();++i){
            System.out.printf("%s : DeviceString %s\n", devices.get(i).getDescription(),devices.get(i).getName());
        }
        System.out.printf("List Device Test Complete--------\n");

        System.out.printf("Capture Device Open Test---------\n");
        PcapIf dev0 = devices.get(1);
        cap = Pcap.openLive(dev0.getName(),
                    2048,
                    Pcap.MODE_PROMISCUOUS,
                    1000*30,
                    errorbuffer);
        assertNotNull(cap);
        System.out.printf("Capture Device Open Test Complete\n");

        cap = Pcap.openOffline("capture/cap.pcap", errorbuffer);
        assertNotNull(cap);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testNext() {
        System.out.printf("Capture Cap Packet---------------\n");
        PcapHeader header = new PcapHeader();
        JBuffer buffer = new JBuffer(JBuffer.Type.POINTER);
        JBuffer retv =  cap.next(header, buffer);
        assertNotNull(retv);
        System.out.printf("Cap Length = %d\n",header.caplen());
        PcapPacket pack = new PcapPacket(header, retv);
        System.out.printf("Packet Header Count = %d\n",pack.getHeaderCount());
        System.out.printf("Capture Cap Packet Complete------\n");
    }
    @Test
    public void testLoop(){
        PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {
			public void nextPacket(PcapPacket packet, String user) {
				Ip4 ip = new Ip4();
                                long t = packet.getCaptureHeader().timestampInMillis();
                                Tcp tcp = new Tcp();
                                Udp udp = new Udp();
                                int s=0;int d=0;
                                int sp=0;int tp=0;
                                int okcount=0;
                                Date arriveTime = new Date(t);
                                if(packet.hasHeader(ip,0)){
                                    s = ip.sourceToInt();
                                    d = ip.destinationToInt();
                                    ++okcount;
                                    // Expect DIP = ca710f02 or ca710f01 , as 202.113.15.1 or 202.113.15.2
                                }
                                if(packet.hasHeader(tcp)){
                                    sp = tcp.source();
                                    tp = tcp.destination();
                                    ++okcount;
                                }
                                if(packet.hasHeader(udp)){
                                    sp = udp.source();
                                    tp = udp.destination();
                                    ++okcount;
                                }
                                if(okcount!=2){
                                    System.out.printf("No Tcp/Ip Capture\n");
                                }else{
                                    System.out.printf("SIP %d:%d DIP %d:%d Arrive Time: %s\n", s,sp,d,tp,arriveTime.toString());
                                }
			}
	};
        cap.loop(10, jpacketHandler, "Loop");
    }

    @Test
    public void testNetwork(){
        INetwork nt = Network.Instance();
        assertNotSame(nt.deviceCount(), 0);
    }
}