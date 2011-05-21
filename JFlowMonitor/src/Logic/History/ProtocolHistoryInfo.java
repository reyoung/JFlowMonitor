/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import Network.IPacket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Reyoung
 */
public class ProtocolHistoryInfo extends RawPacketHistoryInfo{
    public List<IPacket > ProtocolPacket;
    public final static int HTTP = Network.Packet.PacketFlag_HTTP;
    public final static int TCP  = Network.Packet.PacketFlag_TCP;
    public final static int UDP = Network.Packet.PacketFlag_UDP;
    public final static int ETHERNET = Network.Packet.PacketFlag_Ethernet;

//    public final static int FTP = 16; // 未实现
    private int m_protocol ;

    public ProtocolHistoryInfo(Date From,Date To,int Protocol){
        super(From, To);
        ProtocolPacket = new ArrayList<IPacket>();
        m_protocol = Protocol;
    }
    @Override
    protected void process(){
        super.process();
        if(false){  // 为其他情况预留的if语句

        }else{
            for(IPacket p : this.Packets){
                int flag = p.getPacketFlag();
                if(( m_protocol&flag )!=0){
                    ProtocolPacket.add(p);
                }
            }
        }
    }
}
