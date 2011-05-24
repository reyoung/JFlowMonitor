/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.sql.SQLException;
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
//        List<PacketStub> p = new ArrayList<PacketStub>();
//        for(int i=0;i<10;i++)
//        {
//           PacketStub ps = new PacketStub();
//           p.add(ps);
//        }
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
        IDatabaseProxy instance = Database.instance();
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
     * Test of compress method, of class Database.
     */
    @Test
    public void testCompress() throws Exception {
        Date cdate = new Date(111,5,7);
        Database.instance().compress(cdate);
    }

    /**
     * Test of getPacket method, of class Database.
     */
    @Test
    public void testGetPacket_Date() throws Exception {
        System.out.println("getPacket");
        Date cdate = null;
        Database instance = null;
        List expResult = null;
        List result = instance.getPacket(cdate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of getFlow method, of class Database.
     */
    @Test
    public void testGetFlow() throws Exception {
        Date fd = new Date(111,4,10);
        Date td = new Date(111,4,23);
        List<Flow> result;
        try {
            result = Database.instance().getFlow(fd, td);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}