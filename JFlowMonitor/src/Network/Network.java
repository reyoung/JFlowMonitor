/*
 * This file is written by reyoung, reyoung@126.com.
 */
package Network;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

/**
 *
 * @author Reyoung
 */
public class Network implements INetwork {

    private Network() {
        m_listeners = new ArrayList<IPacketListener>();
        m_devices = new ArrayList<PcapIf>();
        StringBuilder buf = new StringBuilder();
        m_listenThread = new ArrayList<ListenThread>();
        int ok = Pcap.findAllDevs(m_devices, buf);
        assert (ok != Pcap.OK && m_devices.isEmpty());
        initThreads();
    }

    static public Network Instance() {
        return m_network;
    }

    public int deviceCount() {
        return m_devices.size();
    }

    public PcapIf getDeviceAt(int i) {
        return m_devices.get(i);
    }

    public void addPacketListener(IPacketListener lis) {
        m_listeners.add(lis);
    }

    public List<IPacketListener> getPacketListeners() {
        return m_listeners;
    }

    private void initThreads() {
        for (int i = 0; i < m_devices.size(); ++i) {
            ListenThread temp = new ListenThread(m_devices.get(i), this);
            m_listenThread.add(temp);
        }
    }

    public void startListenThreads() {
        assert(m_listenThread.isEmpty());
        for(int i=0;i<this.m_listenThread.size();++i){
            m_listenThread.get(i).start();
        }
    }

    static {
        m_network = new Network();
    }
    private ArrayList<PcapIf> m_devices;
    private List<IPacketListener> m_listeners;
    private List<ListenThread> m_listenThread;
    static private Network m_network;

    public void joinAllListenThreads() {
        assert(m_listenThread.isEmpty());
        for(int i=0;i<this.m_listenThread.size();++i){
            try {
                m_listenThread.get(i).join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
