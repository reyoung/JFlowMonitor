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
public interface IPacket {
    public InetSocketAddress getSourceAddress();
    public InetSocketAddress getTargetAddress();
    public int getPacketLength();
    public Date getPacketRecvTime();
}
