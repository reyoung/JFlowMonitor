/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import Database.Database;
import Database.Flow;
import Database.IDatabaseProxy;
import Network.IPacket;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reyoung
 */
public class FlowHistoryInfo extends HistoryInfo{
    public Map<Date,Flow> Data;
    public FlowHistoryInfo(Date From,Date To){
        super(From,To);
        Data = new HashMap<Date, Flow>();
    }
    @Override
    protected void process() {
        IDatabaseProxy ins = Database.instance();
        try {
            List<Flow> flow = ins.getFlow(FromDate, ToDate);
            List<IPacket> ipckets = ins.getPacket(FromDate, ToDate);
            Data.putAll(ConvertPacketToFlow(ipckets));
            for(Flow f:flow){
                Data.put(f.sDate,f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlowHistoryInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

