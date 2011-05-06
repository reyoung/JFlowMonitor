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

    /**
     * 返回包的源地址
     * @return  IPv4地址，int型
     * @note 需要被保存
     */
    public int getSourceAddress();

    /**
     * 返回包的目的地址
     * @return IPv4地址，int型
     * @note 需要被保存
     */
    public int getDestAddress();

    /**
     * 返回源端口
     * @return
     * @note 需要被保存
     */
    public int getSourcePort();

    /**
     * 返回目的端口
     * @return
     * @note 需要被保存
     */
    public int getDestPort();

    /**
     * 返回包长度
     * @return
     * @note 需要被保存
     */
    public int getPacketLength();

    /**
     * 返回包接受时间
     * @note 需要被保存
     * @return
     */
    public Date getPacketRecvTime();

    /**
     * 返回是否是上传包，需要被保存。
     * @note 需要被保存
     * @return
     */
    public boolean isUpload();

    /**
     * 返回源地址字符串形式
     * @note 不需要被保存
     * @return
     */
    public String getSourceAddressString();

    /**
     * 返回目的地址字符串形式
     * @note 不需要被保存
     * @return
     */
    public String getDestAddressString();
}
