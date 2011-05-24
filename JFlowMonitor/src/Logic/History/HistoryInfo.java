/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import Database.Flow;
import Logic.Filters.CernetPacketFilter;
import Network.IPacket;
//import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
//import java.util.ListIterator;
import java.util.Map;
//import oracle.toplink.essentials.internal.expressions.LogicalExpression;

/**
 * HistoryInfo是UI层访问数据库历史的唯一通道！
 *  他可以获得UI层所需要的所有历史数据。
 *  比如，从某天到某天的简单流量信息，可以为
 *      FlowHistoryInfo info = new FlowHistoryInfo(BeginDate,EndDate);
 * @author Reyoung
 */
public abstract class HistoryInfo {
    public Date  FromDate;
    public Date  ToDate;
    public boolean Complete;


    public HistoryInfo(Date FromDate, Date ToDate) {
        this.FromDate = FromDate;
        this.ToDate = ToDate;
        this.Complete = false;
//        this.process();
    }
    public void init(){
        this.process();
    }
    static protected Date NormalizeDate(Date date){
        int d = date.getDate();
        int m = date.getMonth();
        int y = date.getYear();
        return new Date(y, m, d);
    }
    static protected Map<Date,Flow> ConvertPacketToFlow(List<IPacket> packs){
        Map<Date,Flow> table = new HashMap<Date, Flow>();
        Iterator<IPacket> it = packs.iterator();
        while(it.hasNext()){
            IPacket p = it.next();
            Date recv = p.getPacketRecvTime();
            recv = NormalizeDate(recv);
            if(table.containsKey(recv)){
                Flow f = table.get(recv);
                boolean isIn = CernetPacketFilter.Instance().check(p);
                if(isIn)
                    f.innerSize+=(long)p.getPacketLength() / 1024;
                else
                    f.outerSize+=(long)p.getPacketLength() / 1024;
            }else{
                Flow f = new Flow();
                boolean isIn = CernetPacketFilter.Instance().check(p);
                if(isIn)
                    f.innerSize+=(long)p.getPacketLength() / 1024;
                else
                    f.outerSize+=(long)p.getPacketLength() / 1024;
                table.put(recv, f);
            }
        }
        return table;
    }
    abstract protected  void process();
}
