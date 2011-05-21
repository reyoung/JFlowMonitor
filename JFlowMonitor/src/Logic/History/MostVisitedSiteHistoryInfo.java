/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import Network.IPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            int ip = auxlist.get(i).site;
            byte [] ipv4 = convertIp(ip);
            try {
                InetAddress addr = Inet4Address.getByAddress(ipv4);
                MostVisitedSite.add(addr.toString());
            } catch (UnknownHostException ex) {
                Logger.getLogger(MostVisitedSiteHistoryInfo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    static byte [] convertIp(int ipv4){
        byte[] retv = new byte[4];
        retv[0] = (byte) (((ipv4 & (0xff000000)) >> 24) & 0x000000ff);
        retv[1] = (byte) ((ipv4&0x00ff0000)>>16);
        retv[2] = (byte) ((ipv4&0x0000ff00)>>8);
        retv[3] = (byte) (ipv4&0x000000ff);
        return  retv;
    }
}
