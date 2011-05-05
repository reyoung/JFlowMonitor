/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;
import java.util.Date;
/**
 *
 * @author Reyoung
 */
public interface IPacket {
    
    public int getSourceAddress();
    public int getTargetAddress();
    
    public int getSourcePort();
    public int getTargetPort();

    public int getPacketLength();
    
    public Date getPacketRecvTime();
}
