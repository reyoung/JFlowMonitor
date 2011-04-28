/*
 * This file is written by reyoung, reyoung@126.com.
 */

package pcapconsole;
import java.util.Iterator;
import java.util.List;
import org.jnetpcap.*;

/**
 *
 * @author Reyoung
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<PcapIf> devList = null;
        StringBuilder buffer = null;
        Pcap.findAllDevs(devList, buffer);
        Iterator<PcapIf> it = devList.iterator();
        while(it.hasNext()){
            PcapIf n = it.next();
            System.out.print(n.getDescription());
        }
    }

}
