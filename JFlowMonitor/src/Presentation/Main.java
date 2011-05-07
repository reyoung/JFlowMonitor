/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Presentation;

import Logic.Filters.CernetPacketFilter;
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
        INetwork in = Network.Network.Instance();
        in.startListenThreads();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIFrame1().setVisible(true);
                new SmallWindow().setVisible(true);
            }
        });

    }
}
