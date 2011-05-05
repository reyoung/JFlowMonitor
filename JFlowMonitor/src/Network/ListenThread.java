/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import org.jnetpcap.PcapIf;

/**
 *
 * @author Reyoung
 */
public class ListenThread extends Thread
{
    public ListenThread(PcapIf dev,INetwork nw){
        m_dev = dev;
        m_network = nw;
    }
    @Override
    public void run(){
        
    }

    private PcapIf m_dev;
    private INetwork m_network;
}
