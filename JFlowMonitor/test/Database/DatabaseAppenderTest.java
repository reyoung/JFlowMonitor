/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Logic.PacketPool.IPacketPoolEvent;
import Logic.PacketPool.IPacketPoolEventListener;
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
public class DatabaseAppenderTest {

    public DatabaseAppenderTest() {
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
     * Test of Instance method, of class DatabaseAppender.
     */
    @Test
    public void testInstance() {
        System.out.println("Instance");
        IPacketPoolEventListener expResult = null;
        IPacketPoolEventListener result = DatabaseAppender.Instance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onPoolRefresh method, of class DatabaseAppender.
     */
    @Test
    public void testOnPoolRefresh() {
        System.out.println("onPoolRefresh");
        IPacketPoolEvent e = null;
        DatabaseAppender instance = null;
        instance.onPoolRefresh(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEnable method, of class DatabaseAppender.
     */
    @Test
    public void testIsEnable() {
        System.out.println("isEnable");
        DatabaseAppender instance = null;
        boolean expResult = false;
        boolean result = instance.isEnable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class DatabaseAppender.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        DatabaseAppender instance = null;
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}