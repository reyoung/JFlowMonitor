/*
 * This file is written by reyoung, reyoung@126.com.
 */
package Network;

/**
 *
 * @author Reyoung
 */
public abstract class AbstractPacket implements IPacket {
    public String getSourceAddressString(){
        return Ipv4Int2Str(this.getSourceAddress());
    }
    public String getDestAddressString(){
        return Ipv4Int2Str(getDestAddress());
    }
    private static String Ipv4Int2Str(int ipv4) {
        StringBuilder sb = new StringBuilder();
        sb.append(((ipv4 & 0xff000000) >> 24) & 0x000000ff);
        sb.append('.');
        sb.append((ipv4 & 0x00ff0000) >> 16);
        sb.append('.');
        sb.append((ipv4 & 0x0000ff00) >> 8);
        sb.append('.');
        sb.append((ipv4 & 0x000000ff));
        return sb.toString();
    }
}
