/*
 * This file is written by reyoung, reyoung@126.com.
 */
package Logic.PacketPool;

import java.util.Date;
import Network.IPacket;
import Network.Packet;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Reyoung
 */
public class PacketPoolEventTest {

    static public IPacket CreatePacket(Date dat, int s, int sp, int d, int dp, int f, int len, boolean upload) {
        Packet p = new Packet();
        p.RecvTime = dat;
        p.SIP = s;
        p.SPort = sp;
        p.DIP = d;
        p.DPort = dp;
        p.PacketFlag = f;
        p.PackLen = len;
        p.IsUpdate = upload;
        return p;
    }

    public PacketPoolEventTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        m_packets = new ArrayList<IPacket>();
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568452695, 3068, 1208931722, 443, 9, 54, true));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 2111677194, 2892, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568453915, 50647, -568453084, 49913, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931016401, 1379, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -604819859, 14838, -568453084, 49913, 10, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898138452, 1618, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994214992, 4719, -568453084, 52633, 10, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931017119, 51108, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -1570119280, 2918, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1249745234, 80, -568452695, 3071, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568452695, 3071, 1249745234, 80, 9, 54, true));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568454026, 61809, -568453056, 1028, 10, 68, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898141821, 26092, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -604821155, 54197, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1208931722, 443, -568452695, 3068, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -604819942, 22329, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931005544, 50237, -568453084, 52633, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 831262979, 57838, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898560254, 53, -568453056, 1573, 10, 374, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994257107, 64333, -568453084, 49913, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553289, 54710, -568453084, 52633, 10, 98, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931017614, 53428, -568453056, 63889, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -749651603, 54110, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568453075, 62557, 1931016198, 6112, 9, 66, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -604819881, 58155, -568453084, 49913, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -749650199, 1440, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -745041320, 80, -568453056, 65108, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -749651934, 50240, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994258844, 17781, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 2030985759, 80, -568453056, 65040, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -1220801523, 80, -568453056, 65030, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1885335648, 80, -568453056, 65038, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 977014318, 80, -568453056, 65034, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 2006126230, 80, -568453056, 65036, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1884982340, 80, -568453056, 65032, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 831262979, 57838, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -749682706, 64512, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568453923, 58369, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568451818, 34512, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553289, 54710, -568453084, 52633, 10, 98, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1208931722, 80, -568452695, 3074, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568452695, 3074, 1208931722, 80, 9, 54, true));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931006233, 52717, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 831313191, 61948, -568453084, 52633, 10, 80, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568454124, 49387, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994256943, 1074, -568453084, 49913, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994214987, 56249, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931016723, 59525, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994256943, 1074, -568453056, 1028, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931016385, 1131, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994215743, 3364, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898560254, 53, -568453056, 1573, 10, 374, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898141818, 25680, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898517463, 1168, -568453056, 1028, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931006233, 52717, -568453084, 52633, 10, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 831351831, 1135, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -604821101, 63824, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -769509759, 15711, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -1570119280, 2918, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898517444, 1439, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553239, 55237, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931017111, 56017, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -749651648, 52351, -568453056, 1028, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568454026, 61809, -568453056, 1028, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553289, 54710, -568453084, 52633, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553289, 54710, -568453084, 52633, 10, 98, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -606387213, 3615, -568453084, 52633, 10, 229, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553154, 57472, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -1269457320, 50664, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994256943, 1068, -568453084, 52633, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553289, 54710, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568453744, 60134, -568453084, 49913, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568453744, 60134, -568453056, 1028, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553829, 57067, -568453084, 52633, 10, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994212008, 1735, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994258844, 17781, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994231661, 63531, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -769509746, 56885, -568453084, 52633, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898560254, 53, -568453056, 1573, 10, 124, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568454122, 2581, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994214983, 55739, -568453084, 52633, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568454270, 1250, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931017124, 49636, -568453084, 49913, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994257023, 53331, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994175067, 1547, -568453084, 52633, 10, 68, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1885335646, 80, -568453056, 65075, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 2006126205, 80, -568453056, 65069, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -749652286, 64766, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1884981707, 80, -568453056, 65073, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 2030979644, 80, -568453056, 65071, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -604821029, 50524, -568453056, 1028, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898517406, 7747, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994256905, 5088, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898553289, 54710, -568453084, 52633, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994214983, 55739, -568453084, 52633, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1884981707, 80, -568453056, 65024, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 2030979644, 80, -568453056, 65022, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898141821, 58826, -568453084, 52633, 10, 104, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994256943, 1068, -568453084, 52633, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 2006126205, 80, -568453056, 65020, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -1570162425, 57876, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1885335646, 80, -568453056, 65026, 9, 60, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931045939, 49591, -568453084, 52633, 10, 80, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -1570162425, 57876, -568453084, 52633, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994214987, 56249, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 2105158473, 1232, -568453084, 52633, 10, 80, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -749651482, 1536, -568453084, 49913, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 1931016433, 58667, -568453084, 49913, 10, 98, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568453995, 57119, -568453056, 1028, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994175066, 2517, -568453084, 52633, 10, 92, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), 994175066, 2517, -568453084, 52633, 10, 231, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568454222, 8995, -568453084, 49913, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -568454222, 8995, -568453056, 1028, 10, 86, false));
        m_packets.add(CreatePacket(new Date(System.currentTimeMillis()), -898560254, 53, -568453056, 1573, 10, 126, false));
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSomeMethod() {
        int interval = 1;
        IPacketPoolEvent event = new PacketPoolEvent(m_packets, interval);
        assertEquals(event.getIntervalTime(), interval);
        System.out.printf("Current Download Speed = %f Bps\n", event.getDownloadSpeed());
    }
    public static List<IPacket> m_packets;
}
