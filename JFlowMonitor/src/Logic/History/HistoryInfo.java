/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

import java.util.Date;

/**
 *
 * @author Reyoung
 */
public abstract class HistoryInfo {
    public Date  FromDate;
    public Date  ToDate;
    public boolean Complete;


    public HistoryInfo(Date FromDate, Date ToDate) {
        this.FromDate = FromDate;
        this.ToDate = ToDate;
        this.Complete = false;
        this.process();
    }

    abstract protected  void process();
}
