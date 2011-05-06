/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

/**
 *
 * @author Reyoung
 */
public interface IPacketPoolEventListener {
    /**
     * 当当前PacketPool刷新时调用
     * @param e Event
     */
    public void onPoolRefresh(IPacketPoolEvent e);

    /**
     * 是否需要响应刷新事件
     * @return
     */
    public boolean isEnable();

    /**
     * 是否有效
     * 如果无效，在下次刷新时，会被删除
     * @return
     */
    public boolean isValid();
}
