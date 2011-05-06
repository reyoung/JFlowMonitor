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
        StringBuilder sb = new StringBuilder();
        
        sb.append("m_packets.add(CreatePacket(new Date(");
        sb.append("System.currentTimeMillis()");
        sb.append("),");
        sb.append(p.getSourceAddress()).append(',');
        sb.append(p.getSourcePort()).append(',');
        sb.append(p.getDestAddress()).append(',');
        sb.append(p.getDestPort()).append(',');
        sb.append(p.getPacketFlag()).append(',');
        sb.append(p.getPacketLength()).append(',');
        sb.append(p.isUpload()).append("));\n");
        System.out.print(sb.toString());
    }
    
}
