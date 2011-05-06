/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

/**
 *
 * @author Reyoung
 */
public interface IPacketPool {
    public void addPacketPoolListener(IPacketPoolEventListener lis);
    public void setTimerInterval(int tim);
    public void forceRefresh();
}
