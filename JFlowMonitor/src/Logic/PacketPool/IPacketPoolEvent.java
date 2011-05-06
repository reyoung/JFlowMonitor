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
    public int getCurrentInnerUploadSpeed();
    public int getCurrentOutterUploadSpeed();

    public int getCurrentInnerDownloadSpeed();
    public int getCurrentOutterDownloadSpeed();

    public long getIntervalTime();

    public List<Network.IPacket > getRawPackets();
}
