/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import Network.IPacket;
import Network.Packet;
import java.util.ArrayList;
import java.util.Collection;
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
public class MostFlowedSiteHistoryInfo extends RawPacketHistoryInfo{

    public List<String > Sites;
    public List<Integer> SiteFolws;
    private int SiteNum;
    private List<AUX_CLASS> l;
    public MostFlowedSiteHistoryInfo(Date From,Date To,int N) {
        super(From,To);
        Sites = new ArrayList<String>();
        SiteNum = N;
    }
    private Map<String,Integer> SiteMap;
    @Override
    protected void process(){
        super.process();
        SiteMap = new HashMap<String,Integer>();
        SiteFolws = new ArrayList<Integer>();
        l = new ArrayList<AUX_CLASS>();
        getMap();
        getLink();
        getSites();
    }
    private void getMap()
    {
        for(IPacket p : Packets)
        {
            if(p.isUpload())
            {
                if(SiteMap.containsKey(p.getDestAddressString()))
                {
                    int temp = SiteMap.get(p.getDestAddressString());
                    temp += p.getPacketLength();
                    SiteMap.put(p.getDestAddressString(), temp);
                }
                else
                {
                    SiteMap.put(p.getDestAddressString(), p.getPacketLength());
                }
            }
            else
            {
                if(SiteMap.containsKey(p.getSourceAddressString()))
                {
                    int temp = SiteMap.get(p.getSourceAddressString());
                    temp += p.getPacketLength();
                    SiteMap.put(p.getSourceAddressString(), temp);
                }
                else
                {
                    SiteMap.put(p.getSourceAddressString(), p.getPacketLength());
                }
            }
        }
    }
    class AUX_CLASS{
        public int Times;
        public String Site;
        public AUX_CLASS(String site,int time)
        {
            Site = site;
            Times = time;
        }
    }
    private void getLink()
    {
        for(String site : SiteMap.keySet())
        {
            l.add(new AUX_CLASS(site,SiteMap.get(site)));
        }
        java.util.Collections.sort(l, new Comparator<AUX_CLASS>() {
            public int compare(AUX_CLASS o1, AUX_CLASS o2) {
                if(o1.Times > o2.Times)return 1;
                else if(o1.Times == o2.Times)return 0;
                else return -1;
            }
        });
    }
    private void getSites()
    {
        if(!l.isEmpty())
        {
            for(AUX_CLASS e : l)
            {
                if(l.indexOf(e) < SiteNum)
                {
                    Sites.add(e.Site);
                    SiteFolws.add(e.Times);
                }
                else break;
            }
        }
    }
}
