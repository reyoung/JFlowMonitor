/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

import java.util.List;




/**
 * 这个类只可以在IPacketPoolEventListener的时间中出现，如果需要接受这个类
 * 需要继承自IPacketPoolEventListener
 * @author Reyoung
 */
public interface IPacketPoolEvent {
    /**
     * 获得内网上传数度
     * @return 单位 byte per second
     */
    public double getInnerUploadSpeed();

    /**
     * 获得外网上传速度
     * @return 单位 byte per second
     */
    public double getOutterUploadSpeed();

    /**
     * 获得内网下载速度
     * @return 单位 byte per second
     */
    public double getInnerDownloadSpeed();

    /**
     * 获得外网下载速度
     * @return 单位 byte per second
     */
    public double getOutterDownloadSpeed();

    /**
     * 获得上传速度
     * @return 单位 byte per second
     */
    public double getUploadSpeed();

    /**
     * 获得下载速度
     * @return 单位 byte per second
     */
    public double getDownloadSpeed();

    /**
     * 获得刷新时间
     * @return 单位 秒
     */
    public double getIntervalTime();

    public List<Network.IPacket > getRawPackets();
}
