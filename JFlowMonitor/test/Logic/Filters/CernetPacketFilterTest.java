/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.Filters;

import Logic.Filters.CernetPacketFilter;
import Logic.Filters.ICernetReader;
import Logic.Filters.CernetReaderStub;
import Network.IPacket;
import Network.PacketStub;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YQ
 */
public class CernetPacketFilterTest {

    public CernetPacketFilterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of check method, of class CernetPacketFilter.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        IPacket packet = new PacketStub();
        ICernetReader cernetReader = new CernetReaderStub();
        CernetPacketFilter instance = new CernetPacketFilter();
        boolean expResult = false;
        boolean result = instance.check(packet, cernetReader);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}