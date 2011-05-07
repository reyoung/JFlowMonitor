/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Network.PacketStub;
import Network.IPacket;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuziki
 */
public class DatabaseTest {

    public DatabaseTest() {
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
     * Test of savePacket method, of class Database.
     */
    @Test
    public void testSavePacket() {
        PacketStub[] p = new PacketStub[10];
        for(int i=0;i<10;i++)
        {
            p[i] = new PacketStub();
        }
        //Database instance = new Database();
        //instance.savePacket(p);
    }

    /**
     * Test of getConn method, of class Database.
     */
    @Test
    public void testGetConn() throws Exception {
    }

    /**
     * Test of Closedb method, of class Database.
     */
    @Test
    public void testClosedb() throws Exception {
    }


    /**
     * Test of instance method, of class Database.
     */
    @Test
    public void testInstance() {

    }

    /**
     * Test of getPacket method, of class Database.
     */
    @Test
    public void testGetPacket_Date_Date() throws Exception {
        Date from = new Date(111,5,5);
        Date to = new Date(111,5,7);
        IDatabaseProxy instance = Database.instance();
        List result = instance.getPacket(from, to);
        assertNotNull(result);
    }

    /**
     * Test of getPacket method, of class Database.
     */
    @Test
    public void testGetPacket_Date() throws Exception {
        Date cdata = new Date(111,5,6);;
        IDatabaseProxy instance = Database.instance();
        List result = instance.getPacket(cdata);
        assertNotNull(result);
    }

    /**
     * Test of getFlow method, of class Database.
     */
    @Test
    public void testGetFlow_Date_Date() throws Exception {
        Date from = new Date(111,5,4);
        Date to = new Date(111,5,5);
        IDatabaseProxy instance = Database.instance();
        List result = instance.getFlow(from, to);
        assertEquals(2, result.size());
    }

    /**
     * Test of getFlow method, of class Database.
     */
    @Test
    public void testGetFlow_Date() throws Exception {
        Date cdate = new Date(111,5,5);
        IDatabaseProxy instance = Database.instance();
        Flow expResult = new Flow();
        expResult.sDate = cdate;
        expResult.innerSize = 200000;
        expResult.outerSize = 10000;
        Flow result = instance.getFlow(cdate);
        assertEquals(expResult.sDate, result.sDate);
        assertEquals(expResult.innerSize, result.innerSize);
        assertEquals(expResult.outerSize, result.outerSize);
    }

}