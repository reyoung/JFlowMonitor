/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

import Logic.Filters.CernetPacketFilter;
import Logic.Filters.IPacketFilter;
import Network.IPacket;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Reyoung
 */
public class PacketPoolEvent implements IPacketPoolEvent {

    public PacketPoolEvent(List<IPacket > packet,int interval) {
        this.m_packets = packet;
        this.m_interval = interval;
        process();
    }

    public int getCurrentInnerUploadSpeed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCurrentOutterUploadSpeed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCurrentInnerDownloadSpeed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCurrentOutterDownloadSpeed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<IPacket> getRawPackets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public long getIntervalTime() {
        return this.m_interval;
    }

    private void process(){
        ListIterator<IPacket > it = m_packets.listIterator();
        while(it.hasNext()){
            IPacket p = it.next();
            IPacketFilter cernet = CernetPacketFilter.Instance();
        }
    }
    
    private List<IPacket> m_packets;
    private int           m_interval;

}
