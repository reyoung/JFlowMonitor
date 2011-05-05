/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.util.Date;

/**
 *
 * @author Reyoung
 */
public class PacketStub implements IPacket {


    public int getPacketLength() {
        return 1284;
    }

    public Date getPacketRecvTime() {
        return new Date(System.currentTimeMillis());
    }

    public int getSourceAddress() {
        return 0xde1e19a9;
    }

    public int getTargetAddress() {
        return 0xca710f02;
    }

    public int getSourcePort() {
        return 3149;
    }

    public int getTargetPort() {
        return 23;
    }

}
