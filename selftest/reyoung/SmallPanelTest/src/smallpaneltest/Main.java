/*
 * This file is written by reyoung, reyoung@126.com.
 */

package smallpaneltest;

import java.awt.Panel;

/**
 *
 * @author Reyoung
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final SmallPanel panel = new SmallPanel();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                panel.setVisible(true);
            }
        });
    }

}
