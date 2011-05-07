/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Database;

import Network.IPacket;
import Network.Packet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Reyoung
 */
public interface IDatabaseProxy {
    public void savePacket(List<IPacket> p);//N个包插一次
    public List<Packet> getPacket(Date cdate)throws SQLException;//查询某一天的包
    public List<Packet> getPacket(Date from,Date to) throws SQLException;//查询几天之间的包
    public List<Flow> getFlow(Date from,Date to)throws SQLException;//查询几天之间的流量
    public Flow getFlow(Date cdate)throws SQLException;//查询某天的流量
}
