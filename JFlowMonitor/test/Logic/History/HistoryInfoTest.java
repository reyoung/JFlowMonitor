/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Reyoung
 */
public class HistoryInfoTest {

    public HistoryInfoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSomeMethod() {
        Date dat = new Date(2001, 11, 10, 18,32, 23);
        dat = HistoryInfo.NormalizeDate(dat);
        assertEquals(dat, new Date(2001,11,10));
    }

}