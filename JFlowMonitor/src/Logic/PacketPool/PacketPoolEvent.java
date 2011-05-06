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


    public long getIntervalTime() {
        return this.m_interval;
    }

    private void process(){
        ListIterator<IPacket > it = m_packets.listIterator();
        while(it.hasNext()){
            IPacket p = it.next();
            IPacketFilter cernet = CernetPacketFilter.Instance();
            boolean isInner = cernet.check(p);
            if(isInner){
                if(p.isUpload())
                    m_IU += p.getPacketLength();
                else
                    m_ID += p.getPacketLength();
            }else{
                if(p.isUpload())
                    m_OU += p.getPacketLength();
                else
                    m_OD += p.getPacketLength();
            }
        }
    }
    
    private List<IPacket> m_packets;
    private int           m_interval;
    private int           m_IU;
    private int           m_ID;
    private int           m_OU;
    private int           m_OD;
    public double getInnerUploadSpeed() {
        return (double)m_IU/(double) m_interval;
    }

    public double getOutterUploadSpeed() {
        return (double)m_OU/(double) m_interval;
    }

    public double getInnerDownloadSpeed() {
        return (double)m_ID/(double) m_interval;
    }

    public double getOutterDownloadSpeed() {
        return (double)m_OD/(double) m_interval;
    }

    public List<IPacket> getRawPackets() {
        return this.m_packets;
    }

    public double getUploadSpeed() {
        return this.getInnerUploadSpeed()+ this.getOutterUploadSpeed();
    }

    public double getDownloadSpeed() {
        return this.getOutterDownloadSpeed()+this.getInnerDownloadSpeed();
    }
    
}
