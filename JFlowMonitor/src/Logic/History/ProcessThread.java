/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.History;

/**
 *
 * @author Reyoung
 */
public class ProcessThread extends Thread{
    ProcessCompleteListener m_listener;
    HistoryInfo             m_info;

    public ProcessThread(ProcessCompleteListener lis,HistoryInfo h){
        m_listener = lis;
        m_info = h;
    }

    @Override
    public void run(){
        m_info.process();
        synchronized(this){
            m_listener.onProcessComplete(m_info);
        }
    }
}
