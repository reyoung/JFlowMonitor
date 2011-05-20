/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Presentation;

import Database.DatabaseAppender;
import Logic.Filters.CernetPacketFilter;
import Logic.PacketPool.PacketPool;
import Network.INetwork;

/**
 *
 * @author Reyoung
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        CernetPacketFilter.Initialize("Cernet");
        PacketPool.Instance().addPacketPoolListener(DatabaseAppender.Instance());
        INetwork in = Network.Network.Instance();
        in.startListenThreads();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmallWindow().setVisible(true);
                new MainWindow().setVisible(true);
            }
        });

    }
}
