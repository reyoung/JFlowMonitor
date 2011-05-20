/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Reyoung
 */
public class MostFlowedSiteHistoryInfo extends RawPacketHistoryInfo{

    public List<String > Sites;
    public MostFlowedSiteHistoryInfo(Date From,Date To,int N) {
        super(From,To);
    }

    @Override
    protected void process(){
        super.process();
        
    }
}
