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
public class MostVisitedSiteHistoryInfo extends RawPacketHistoryInfo{

    List<String > m_siteIp;
    public MostVisitedSiteHistoryInfo(Date From,Date To,int N) {
        super(From,To);
    }

    @Override
    protected void process(){
        super.process();
        //! TODO Process MostVisitedSite History Info
    }
}
