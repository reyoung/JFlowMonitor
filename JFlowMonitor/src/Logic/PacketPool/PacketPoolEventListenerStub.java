/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.PacketPool;

/**
 *
 * @author Reyoung
 */
public class PacketPoolEventListenerStub implements IPacketPoolEventListener{

    public void onPoolRefresh(IPacketPoolEvent e) {
        System.out.printf("Current Downspeed = %f\n",e.getDownloadSpeed()); 
    }

    public boolean isEnable() {
        return true;
    }

    public boolean isValid() {
        return true;
    }

}
