/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import Database.Database;
import Network.IPacket;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reyoung
 */
public class RawPacketHistoryInfo extends HistoryInfo {
    public List<IPacket> Packets;
    public RawPacketHistoryInfo(Date From ,Date To){
        super(From,To);
    }
    
    @Override
    protected void process() {
        try {
            Packets = Database.instance().getPacket(FromDate, ToDate);
        } catch (SQLException ex) {
            Logger.getLogger(RawPacketHistoryInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
