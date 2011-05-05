/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jnetpcap.*;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

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
				System.out.printf("Received packet at %s caplen=%-4d len=%-4d %s\n",
				    new Date(packet.getCaptureHeader().timestampInMillis()),
				    packet.getCaptureHeader().caplen(),  // Length actually captured
				    packet.getCaptureHeader().wirelen(), // Original length
				    user                                 // User supplied object
				    );
			}
	};
        cap.loop(10, jpacketHandler, "Loop");
    }
}