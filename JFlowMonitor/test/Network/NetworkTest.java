/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jnetpcap.*;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.packet.PcapPacket;

/**
 *
 * @author Reyoung
 */
public class NetworkTest {

    public NetworkTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSomeMethod() {
        System.out.printf("List Device Test-----------------\n");
        ArrayList<PcapIf> devices = new ArrayList<PcapIf>();
        StringBuilder     errorbuffer = new StringBuilder();
        int ok = Pcap.findAllDevs(devices, errorbuffer);
        assertEquals(ok, 0);
        assertNotSame(devices.size(),0);
        for(int i=0;i<devices.size();++i){
            System.out.printf("%s : DeviceString %s\n", devices.get(i).getDescription(),devices.get(i).getName());
        }
        System.out.printf("List Device Test Complete--------\n");

        System.out.printf("Capture Device Open Test---------\n");
        PcapIf dev0 = devices.get(0);
        Pcap cap = Pcap.openLive(dev0.getName(),
                    2048,
                    Pcap.MODE_PROMISCUOUS,
                    1000*30,
                    errorbuffer);
        assertNotNull(cap);
        System.out.printf("Capture Device Open Test Complete\n");

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

}