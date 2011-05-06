/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.Filters;

import Network.IPacket;

/**
 *
 * @author Reyoung
 */
public class HttpFilter implements IPacketFilter{

    private HttpFilter(){
        
    }
    private static HttpFilter instance=null;
    static public IPacketFilter Instance(){
        if(instance==null){
            instance = new HttpFilter();
        }
        return instance;
    }
    public boolean check(IPacket packet) {
        return (packet.getPacketFlag()&packet.PacketFlag_HTTP)!=0;
    }
}
