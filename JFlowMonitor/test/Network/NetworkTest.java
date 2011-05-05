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
        Pcap.findAllDevs(devices, errorbuffer);
        assertNotSame(devices.size(),0);
        for(int i=0;i<devices.size();++i){
            System.out.printf("%s : DeviceString %s\n", devices.get(i).getDescription(),devices.get(i).getName());
        }
        System.out.printf("List Device Test Complete--------\n");
    }

}