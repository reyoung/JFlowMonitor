/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Network.IPacket;
import java.util.List;

/**
 *
 * @author Kuziki
 */
public class DatabaseThread extends Thread{
    private List<IPacket> p = null;
    public DatabaseThread(List<IPacket> packet)
    {
        p = packet;
    }
    public void run()
    {
        Database.instance().savePacket(p);
    }
}
