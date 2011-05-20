/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Network.IPacket;
import Network.Packet;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author Kuziki
 */
public class DatabaseThread{
    private List<IPacket> p = null;
    private Timer timer;
    public  DatabaseThread()
    {
        p = new ArrayList<IPacket>();
        timer = new Timer();
//        timer.schedule(new MyTask(), 0, 10000);
        timer.schedule(new MyTask(),0,10000);
    }
    public void addPackets(List<IPacket> packet)
    {
        p.addAll(packet);
    }
    class MyTask extends java.util.TimerTask{
        @Override
        public void run(){
            if(p != null && p.size() > 0)
            {
                Database.instance().savePacket(p);
                p.clear();
            }
        }
    }

}
