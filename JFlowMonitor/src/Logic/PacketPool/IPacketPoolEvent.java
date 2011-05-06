/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

import java.util.List;



/**
 *
 * @author Reyoung
 */
public interface IPacketPoolEvent {
    public double getInnerUploadSpeed();
    public double getOutterUploadSpeed();

    public double getInnerDownloadSpeed();
    public double getOutterDownloadSpeed();

    public double getUploadSpeed();
    public double getDownloadSpeed();

    public long getIntervalTime();

    public List<Network.IPacket > getRawPackets();
}
