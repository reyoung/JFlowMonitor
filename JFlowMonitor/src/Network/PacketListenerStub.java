/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Network;

/**
 *
 * @author Reyoung
 */
public class PacketListenerStub implements IPacketListener{

    public void onPacketRecv(IPacket p) {
        System.out.printf("%s: Recv %d bytes From %s:%d To %s:%d\n",
                p.getPacketRecvTime().toString(),
                p.getPacketLength(),
                p.getSourceAddressString(),
                p.getSourcePort(),
                p.getDestAddressString(),
                p.getDestPort()
                );
    }
    
}
