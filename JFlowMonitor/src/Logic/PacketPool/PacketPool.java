/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

import Network.IPacket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Reyoung
 */
public class PacketPool extends TimerTask implements Network.IPacketListener,IPacketPool{
    private PacketPool(){
        this.m_timer = new Timer();
        m_interval = 1000;
        m_listeners = new ArrayList<IPacketPoolEventListener>();
        m_packets = new ArrayList<IPacket>();
//        forceRefresh();
        this.m_timer.schedule(this,0,this.m_interval);
    }
    private static IPacketPool instance = null;
    static IPacketPool Instance(){
        if(instance==null){
            PacketPool temp = new PacketPool();
            Network.Network.Instance().addPacketListener(temp);
            instance = temp;
        }
        return instance;
    }
    public void addPacketPoolListener(IPacketPoolEventListener lis ) {
        this.m_listeners.add(lis);
    }
    
    public void setTimerInterval(int tim) {
        this.m_interval = tim;
        this.m_timer.cancel();
        this.m_timer.schedule(this,0,this.m_interval);
    }
    public void onPacketRecv(IPacket p) {
        synchronized(m_packets){
            m_packets.add(p);
        }
    }

    public final void forceRefresh() {
        PacketPoolEvent event = new PacketPoolEvent(this.m_packets,this.m_interval);
        for(int i=0;i<m_listeners.size();++i){
            IPacketPoolEventListener temp = m_listeners.get(i);
            if(!temp.isValid()){
                this.m_listeners.remove(i);
                --i;
            }
            if(temp.isEnable()){
                temp.onPoolRefresh(event);
            }
        }
        this.m_packets.clear();
    }

    @Override
    public void run() {
        synchronized(m_packets){
            this.forceRefresh();
        }
    }

    private ArrayList<IPacketPoolEventListener> m_listeners;
    private int                                 m_interval;
    private Timer                               m_timer;
    final private ArrayList<IPacket>                  m_packets;




}
