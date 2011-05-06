/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.Filters;


/**
 *
 * @author Reyoung
 */
public class FilterFactory {
    static IPacketFilter getFilterByName(String n){
        if(n.equals(HttpFilter.class.getSimpleName())){
            return HttpFilter.Instance();
        }else if(n.equals(TcpFilter.class.getSimpleName())){
            return TcpFilter.Instance();
        }else if(n.equals(CernetPacketFilter.class.getSimpleName())){
            return CernetPacketFilter.Instance();
        }
        return null;
    }
}
