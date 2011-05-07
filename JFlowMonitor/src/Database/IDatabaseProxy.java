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

    public void savePacket(IPacket[] p);//10个包插一次  // TODO 更新文档，还是每十个包插一次？参数用List，不用数组


    /**
     * TODO      !!!为什么用Check这个动词？应该用get获取属性，check做检查，应该返回boolean型。
     *           比如getPacket就Ok了，我没必要知道这么多函数，不同的参数就好了。
     *           比如，getPacket(Date curDate);getPacket(Date From, Date to);
     *                 getSimpleData(Date curDate); getSimpleDate(Date from , Date to);
     *           另外，SimpleDate是什么？简单的日期？拼写错了吧。
     */
    public List<Packet> checkDate(Date cdate)throws SQLException;//查询某一天的包
    public List<Packet> checkDatetoDate(Date from,Date to) throws SQLException;//查询几天之间的包
    public List<SimpleDate> checkFlowDtD(Date from,Date to)throws SQLException;//查询几天之间的流量
    public SimpleDate checkFlow(Date cdate)throws SQLException;//查询某天的流量
}
