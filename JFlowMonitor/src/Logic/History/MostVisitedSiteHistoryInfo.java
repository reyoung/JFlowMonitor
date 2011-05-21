/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import Network.IPacket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Reyoung
 */
public class MostVisitedSiteHistoryInfo extends ProtocolHistoryInfo{
    public List<String > MostVisitedSite;
    private int m_limit;
    public MostVisitedSiteHistoryInfo(Date From,Date To,int N){
        super(From, To, HTTP); //! 只使用HTTP包
        m_limit = N;
    }
    class __AUX_Class{
        public int site;
        public int times;
    }
    @Override
    protected void process(){
        super.process();
        MostVisitedSite = new ArrayList<String>();
        Map<Integer , Integer> ipMap = new HashMap<Integer, Integer>();
        for(IPacket p : this.ProtocolPacket){
            if(p.isUpload()){
                if(ipMap.containsKey(p.getDestAddress())){
                    Integer value = ipMap.get(p.getDestAddress())+1;
                    ipMap.put(p.getDestAddress(), value);
                }else{
                    ipMap.put(p.getDestAddress(), 1);
                }
            }
        }
        List<__AUX_Class> auxlist = new ArrayList<__AUX_Class>();
        for(Map.Entry<Integer,Integer> p: ipMap.entrySet()){
            __AUX_Class c = new __AUX_Class();
            c.site = p.getKey();
            c.times = p.getValue();
            auxlist.add(c);
        }
        Collections.sort(auxlist, new Comparator() {
            public int compare(Object o1, Object o2) {
                __AUX_Class c1 = (__AUX_Class)o1;
                __AUX_Class c2 = (__AUX_Class)o2;
                if(c1.times<c2.times){
                    return 1;
                }else if(c1.times>c2.times){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        for(int i=0;i< (m_limit<auxlist.size()?m_limit:auxlist.size());++i){
            MostVisitedSite.add(Integer.toString(auxlist.get(i).site));
        }
    }
}
