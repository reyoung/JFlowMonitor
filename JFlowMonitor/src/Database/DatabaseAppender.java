/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Database;

import Logic.PacketPool.IPacketPool;
import Logic.PacketPool.IPacketPoolEvent;
import Logic.PacketPool.IPacketPoolEventListener;
import Logic.PacketPool.PacketPool;
import Network.IPacket;
import java.util.List;

/**
 *
 * @author Reyoung
 */
public class DatabaseAppender implements IPacketPoolEventListener{
    private DatabaseAppender(){
    }
    static private DatabaseAppender instance = null;
    public static IPacketPoolEventListener Instance(){
        if(instance == null){
            instance = new DatabaseAppender();
        }
        return instance;
    }

    public void onPoolRefresh(IPacketPoolEvent e) {
        List<IPacket> packets = e.getRawPackets();
        // TODO 添加将Packets保存到database的过程
    }

    /**
     * 永远相应Packet Pool的更新Event
     * @return
     */
    final public boolean isEnable() {
        return true;
    }
    /**
     * 永远有效
     * @return
     */
    final public boolean isConcern() {
        return true;
    }
    static{
        IPacketPool pp = PacketPool.Instance();
        pp.addPacketPoolListener(DatabaseAppender.Instance());
    }
}
