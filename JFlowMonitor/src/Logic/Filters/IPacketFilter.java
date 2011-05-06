/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Logic.Filters;
import Network.IPacket;
/**
 *
 * @author Reyoung
 */
public interface IPacketFilter {
    /**
     * Filter 过滤器
     * 因为过滤器有很多类型，比如内外网过滤器，HTTP过滤器，所以，不能再接口的check传入其他参数
     * CernetReader应该是你的Filter内部维护的东西，而不应该修改全局的接口
     * @param packet
     * @return
     */
    public boolean check(IPacket packet);
}
