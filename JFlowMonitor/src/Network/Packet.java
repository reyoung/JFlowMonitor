/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.util.Date;

/**
 *
 * @author Reyoung
 */
public class Packet extends AbstractPacket{
    public int SIP;
    public int DIP;
    public int SPort;
    public int DPort;
    public Date RecvTime;
    public boolean IsUpdate;
    public int PackLen;
    public int PacketFlag;
    public Packet(){
        RecvTime = null;
    }


    public int getSourceAddress() {
        return SIP;
    }

    public int getDestAddress() {
        return DIP;
    }

    public int getSourcePort() {
        return SPort;
    }

    public int getDestPort() {
        return DPort;
    }

    public int getPacketLength() {
        return PackLen;
    }

    public Date getPacketRecvTime() {
        return RecvTime;
    }

    public boolean isUpload() {
        return IsUpdate;
    }

    public int getPacketFlag() {
        return PacketFlag;
    }

}
