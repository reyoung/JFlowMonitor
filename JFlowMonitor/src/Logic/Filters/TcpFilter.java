/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.Filters;

import Network.IPacket;

/**
 *
 * @author Reyoung
 */
public class TcpFilter implements IPacketFilter{
    private TcpFilter(){

    }
    private static TcpFilter instance = null;
    static public TcpFilter Instance(){
        if(instance == null){
            instance = new TcpFilter();
        }
        return instance;
    }

    public boolean check(IPacket packet) {
        return (packet.getPacketFlag()&IPacket.PacketFlag_TCP)!=0;
    }
    
}
