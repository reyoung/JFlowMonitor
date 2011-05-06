/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

import Network.IPacket;
import java.util.List;

/**
 *
 * @author Reyoung
 */
public class PacketPoolEvent implements IPacketPoolEvent {

    public PacketPoolEvent(List<IPacket > packet,int interval) {
        this.m_packets = packet;
        this.m_interval = interval;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private List<IPacket> m_packets;
    private int           m_interval;

}
