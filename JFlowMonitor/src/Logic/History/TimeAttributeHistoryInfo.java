/*
 * This file is written by reyoung, reyoung@126.com.
 */
package Logic.History;

import Network.IPacket;
import java.util.Date;

/**
 *
 * @author Reyoung
 */
public class TimeAttributeHistoryInfo extends RawPacketHistoryInfo {
    public long[] TimeBytes;
    public TimeAttributeHistoryInfo(Date From, Date To) {
        super(From, To);
        TimeBytes = new long[24];
    }
    @Override
    public void process() {
        super.process();
        for (int i = 0; i < TimeBytes.length; ++i) {
            TimeBytes[i] = 0;
        }
        for (IPacket p : this.Packets) {
            int l = p.getPacketLength();
            Date d = p.getPacketRecvTime();
            TimeBytes[d.getHours()]+=l;
        }
    }
}