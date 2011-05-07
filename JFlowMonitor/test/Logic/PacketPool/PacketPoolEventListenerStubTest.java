/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

import Network.Network;
import Network.INetwork;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Reyoung
 */
public class PacketPoolEventListenerStubTest {

    public PacketPoolEventListenerStubTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSomeMethod() {
        INetwork in = Network.Instance();
        IPacketPool pp =  PacketPool.Instance();
        pp.addPacketPoolListener(new PacketPoolEventListenerStub());
//        pp.setTimerInterval(1000);
//        in.startListenThreads();
//        in.joinAllListenThreads();
    }

}