/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.History;

import java.util.Date;
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
public class MostFlowedSiteHistoryInfoTest {

    public MostFlowedSiteHistoryInfoTest() {
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
     * Test of process method, of class MostFlowedSiteHistoryInfo.
     */
    @Test
    public void testProcess() {
        MostFlowedSiteHistoryInfo instance = new MostFlowedSiteHistoryInfo(new Date(111,4,19),new Date(111,4,22),5);
        instance.process();
        // TODO review the generated test code and remove the default call to fail.
        for(String t : instance.Sites)
        {
            System.out.println(t);
        }
        for(int i : instance.SiteFolws)
        {
            System.out.println(i);
        }
    }

}