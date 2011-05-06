/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Filters;

import Network.*;
import java.util.List;

/**
 *
 * @author YQ
 */
public class CernetPacketFilter extends AbstractPacketFilter {
    private static CernetPacketFilter m_cernetPacketFilter = null;
    CernetReader m_cernetReader =new CernetReader();
    public static IPacketFilter Instance(){
        if(m_cernetPacketFilter == null){
            m_cernetPacketFilter = new CernetPacketFilter();
        }
        return m_cernetPacketFilter;
    }
    private CernetPacketFilter(){

    }
    public boolean check(IPacket packet) {
        boolean isInCernet = false;
        int targetAddress = packet.getDestAddress();
        int cernetAddress = 0;
        int cernerMask = 0;
        List<CernetAttribute<String, String>> cernetDataList = m_cernetReader.getCernetAttribute();
        for (int i = 0; i < cernetDataList.size(); ++i) {
            CernetAttribute<String, String> c = cernetDataList.get(i);
            cernetAddress = ipToInt(c.ip);
            cernerMask = ipToInt(c.mask);
            if ((cernetAddress & cernerMask) == (targetAddress & cernerMask)) {
                isInCernet = true;
                break;
            }
        }
        return isInCernet;
    }
//    public boolean check(IPacket packet) {
//        if(((int)System.currentTimeMillis()&1)==0)
//            return true;
//        else
//            return false;
//    }
}
