/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    @Override
    protected void process(){
        super.process();
        MostVisitedSite = new ArrayList<String>();
        
    }
}
