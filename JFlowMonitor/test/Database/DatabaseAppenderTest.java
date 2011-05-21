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
    }

    /**
     * Test of onPoolRefresh method, of class DatabaseAppender.
     */
    @Test
    public void testOnPoolRefresh() {
        IPacketPoolEvent e = null;
        DatabaseAppender instance = null;
        instance.onPoolRefresh(e);
    }

    /**
     * Test of isEnable method, of class DatabaseAppender.
     */
    @Test
    public void testIsEnable() {
    }

    /**
     * Test of isValid method, of class DatabaseAppender.
     */
    @Test
    public void testIsValid() {
    }

}