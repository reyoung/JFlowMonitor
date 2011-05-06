/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

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
public class AbstractPacketFilterTest {

    public AbstractPacketFilterTest() {
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
     * Test of Ipv4Int2ByteArray method, of class AbstractPacketFilter.
     */
    @Test
    public void testIpv4Int2ByteArray() {
//        System.out.println("Ipv4Int2ByteArray");
//        int ipv4 = 0;
//        byte[] expResult = null;
//        byte[] result = AbstractPacketFilter.Ipv4Int2ByteArray(ipv4);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ipToInt method, of class AbstractPacketFilter.
     */
    @Test
    public void testIpToInt() {
        System.out.println("ipToInt");
        String strIP = "202.113.15.2";
        long expResult = 0xca710f02;
        long result = AbstractPacketFilter.ipToInt(strIP);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of intToIP method, of class AbstractPacketFilter.
     */
    @Test
    public void testIntToIP() {
        System.out.println("intToIP");
        int intIP = 0xca710f02;
        String expResult = "202.113.15.2";
        String result = AbstractPacketFilter.intToIP(intIP);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}