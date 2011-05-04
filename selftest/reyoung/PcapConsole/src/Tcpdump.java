/*
 * This file is written by reyoung, reyoung@126.com.
 */
/**
 *
 * @author Reyoung
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.jnetpcap.*;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.nio.JBufferInputStream;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.PcapPacket;
class Tcpdump  {

	public static void main(String[] args) throws IOException{
            List< PcapIf > devices = new ArrayList<PcapIf>() {};
            StringBuilder buf = new StringBuilder();
            if(Pcap.findAllDevs(devices, buf)!=0){
                System.out.printf("ErrBuf = %s\n",buf);
            }
            ListIterator<PcapIf> it = devices.listIterator();
            while(it.hasNext()){
                System.out.printf("Device %s\n",it.next().getDescription());
            }
            it= devices.listIterator();
            it.next();
            Pcap cap = Pcap.openLive( it.next().getName(),
                        1024,
                        Pcap.MODE_PROMISCUOUS,
                        1000*30,
                        buf);
            if(cap==null){
                System.out.printf("Capture Error\n");
            }
            PcapHeader header = new PcapHeader();
            JBuffer buffer = new JBuffer(JBuffer.Type.POINTER);
            JBuffer retv =  cap.next(header, buffer);
            System.out.printf("OK!\n");
            if(retv == null){
                System.err.printf("No Packet Captured\n"); 
            }else{
                if(retv instanceof JPacket){
                    JPacket pack = (JPacket) retv;
                }else{
                    JBufferInputStream bin = new JBufferInputStream(retv);
                    System.out.printf("Packet Size = %d\n", bin.available());
                    
                }
            }
	}
}
