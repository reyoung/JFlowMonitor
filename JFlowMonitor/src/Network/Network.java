/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.util.ArrayList;
import java.util.List;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

/**
 *
 * @author Reyoung
 */
public class Network implements INetwork{
    private Network(){
        m_listeners = new ArrayList<IPacketListener>();
        m_devices = new ArrayList<PcapIf>();
        StringBuilder buf = new StringBuilder();
        int ok = Pcap.findAllDevs(m_devices, buf);
        if(ok != Pcap.OK && m_devices.isEmpty()){
            assert(false);
        }
    }
    static public Network Instance(){
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
    static{
        m_network = new Network();
    }
    private ArrayList<PcapIf>          m_devices;
    private List<IPacketListener> m_listeners;
    static private Network        m_network;
}
