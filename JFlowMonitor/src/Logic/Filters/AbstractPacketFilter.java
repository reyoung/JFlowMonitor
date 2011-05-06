/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.Filters;

/**
 *
 * @author YQ
 */
public abstract class AbstractPacketFilter implements IPacketFilter{
    static protected  byte[] Ipv4Int2ByteArray(int ipv4){
        byte[] retv = new byte[4];
        retv[0] = (byte) (((ipv4 & (0xff000000)) >> 24) & 0x000000ff);
        retv[1] = (byte) ((ipv4&0x00ff0000)>>16);
        retv[2] = (byte) ((ipv4&0x0000ff00)>>8);
        retv[3] = (byte) (ipv4&0x000000ff);
        return  retv;
    }
    static protected int ipToInt(String strIP)
     //将127.0.0.1 形式的IP地址转换成10进制整数，这里没有进行任何错误处理
     {
          int[] ip=new int[4];
          int position1=strIP.indexOf(".");
          int position2=strIP.indexOf(".",position1+1);
          int position3=strIP.indexOf(".",position2+1);
          ip[0]=(int) Long.parseLong(strIP.substring(0,position1));
          ip[1]=(int) Long.parseLong(strIP.substring(position1+1,position2));
          ip[2]=(int) Long.parseLong(strIP.substring(position2+1,position3));
          ip[3]=(int) Long.parseLong(strIP.substring(position3+1));
          return (ip[0]<<24)+(ip[1]<<16)+(ip[2]<<8)+ip[3];
     }
     static protected String intToIP(int intIP)
     {
          StringBuilder sb=new StringBuilder("");
          sb.append(String.valueOf(intIP>>>24));//直接右移24位
          sb.append(".");
           //将高8位置0，然后右移16位
          sb.append(String.valueOf((intIP&0x00FFFFFF)>>>16));
          sb.append(".");
          sb.append(String.valueOf((intIP&0x0000FFFF)>>>8));
          sb.append(".");
          sb.append(String.valueOf(intIP&0x000000FF));
          return sb.toString();
     }
}
