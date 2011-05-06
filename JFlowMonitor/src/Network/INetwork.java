/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.util.List;
import org.jnetpcap.PcapIf;

/**
 *
 * @author Reyoung
 */
public interface INetwork {
    /**
     * 返回当前计算机的网卡数量
     * @return
     */
    public int deviceCount();

    /**
     * 返回在第i点的网卡
     * @param i index
     * @return PcapIf类，具有网卡名称，描述等
     */
    public PcapIf getDeviceAt(int i);

    /**
     * 添加订阅Packet消息的类
     * @param lis   订阅Packet的类的接口
     */
    public void addPacketListener(IPacketListener lis);

    /**
     * 返回所有订阅Packet的类。
     * @return
     */
    public List<IPacketListener> getPacketListeners();

    /**
     * 开始所有的监听进程。每个网卡独立一个监听进程。
     */
    public void startListenThreads();

    /**
     * 
     */
    public void joinAllListenThreads();
}
