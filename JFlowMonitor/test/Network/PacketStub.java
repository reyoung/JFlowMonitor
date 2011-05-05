/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.net.InetSocketAddress;
import java.util.Date;

/**
 *
 * @author Reyoung
 */
public class PacketStub implements IPacket {

    public InetSocketAddress getSourceAddress() {
        return new InetSocketAddress("127.0.0.1",5311);
    }

    public InetSocketAddress getTargetAddress() {
        return new InetSocketAddress("67.220.91.23",80);
    }

    public int getPacketLength() {
        return 1284;
    }

    public Date getPacketRecvTime() {
        return new Date(System.currentTimeMillis());
    }

}
