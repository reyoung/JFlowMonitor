/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.util.Date;


/**
 *
 * @author Kuziki
 */
public class Flow {
    public Date sDate;
    public long innerSize;
    public long outerSize;
    public Flow(){
        innerSize = 0;
        outerSize = 0;
        sDate = new Date();
    }
}
