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
    public int getDestAddress();
    
    public int getSourcePort();
    public int getDestPort();

    public int getPacketLength();
    
    public Date getPacketRecvTime();

    public boolean isUpload();
    
}
