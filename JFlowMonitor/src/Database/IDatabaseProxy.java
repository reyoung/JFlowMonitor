/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Database;

import Network.IPacket;

/**
 *
 * @author Reyoung
 */
public interface IDatabaseProxy {
    public void savePacket(IPacket p);
}
