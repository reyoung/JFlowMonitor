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

    public boolean check(IPacket packet, ICernetReader cernetReader) {
        boolean isInCernet = false;
        int targetAddress = packet.getDestAddress();
        int cernetAddress = 0;
        int cernerMask = 0;
        List<CernetAttribute<String, String>> cernetDataList = cernetReader.getCernetAttribute();
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
}
