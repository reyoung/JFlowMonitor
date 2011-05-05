/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

import java.util.List;
import org.jnetpcap.PcapIf;

/**
 *
 * @author Reyoung
 */
public interface INetwork {
    public int deviceCount();
    public PcapIf getDeviceAt(int i);
    
    public void addPacketListener(IPacketListener lis);
    public List<IPacketListener> getPacketListeners();
}
