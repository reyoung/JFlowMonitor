/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.util.ArrayList;
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
        List<PacketStub> p = new ArrayList<PacketStub>();
        for(int i=0;i<10;i++)
        {
           PacketStub ps = new PacketStub();
           p.add(ps);
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
        Date from = new Date(111,5,5);
        Date to = new Date(111,5,6);
        Long fd = from.getTime();
        Long td = to.getTime();
        System.out.println(fd);
        System.out.println(td);
        System.out.println(td - fd);
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
        Date from = new Date(111,4,4);
        Date to = new Date(111,4,6);
        IDatabaseProxy instance = Database.instance();
        List result = instance.getFlow(from, to);
        //assertEquals(2, result.size());
    }

    /**
     * Test of getFlow method, of class Database.
     */
    /*
    @Test
    public void testGetFlow_Date() throws Exception {
        Date cdate = new Date(111,4,5);
        IDatabaseProxy instance = Database.instance();
        Flow expResult = new Flow();
        expResult.sDate = cdate;
        expResult.innerSize = 20057;
        expResult.outerSize = 10000;
        Flow result = instance.getFlow(cdate);
        assertEquals(expResult.sDate, result.sDate);
        assertEquals(expResult.innerSize, result.innerSize);
        assertEquals(expResult.outerSize, result.outerSize);
    }
    */
    /**
     * Test of compress method, of class Database.
     */
    @Test
    public void testCompress() throws Exception {
        Date cdate = new Date(111,5,7);
        Database.instance().compress(cdate);
    }

}