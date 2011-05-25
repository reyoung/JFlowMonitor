/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.History;

import Database.Database;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kuziki
 */
public class HistoryCompressThread extends Thread{
    Date deadDay;
     public HistoryCompressThread(Date t)
     {
         deadDay = t;
     }
     @Override
     public void run(){
        try {
            Database.instance().compress(deadDay);
        } catch (SQLException ex) {
            Logger.getLogger(HistoryCompressThread.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
