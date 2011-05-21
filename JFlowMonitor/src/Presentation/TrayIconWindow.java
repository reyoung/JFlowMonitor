/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
/**
 *
 * @author YQ
 */
public class TrayIconWindow {
    private TrayIconWindow(){
        initComponents();
    }
    static TrayIconWindow instance = null;
    static public TrayIconWindow Instance(){
        if(instance==null){
            instance = new TrayIconWindow();
        }
        return instance;
    }
    private TrayIcon m_trayIcon;
    static public void showMessage(String title,String msg){
        Instance().m_trayIcon.displayMessage(title, msg, TrayIcon.MessageType.INFO);
    }


    private void initComponents()
    {
         try
        {
            if (SystemTray.isSupported())
            {// 判断当前平台是否支持系统托盘
                SystemTray st = SystemTray.getSystemTray();
                PopupMenu pm = new PopupMenu();//创建右键菜单
                MenuItem changeUserMenu = new MenuItem("Show Statics");
                changeUserMenu.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        onStaticsShow();
                    }
                });
                MenuItem exitMenu = new MenuItem("Exit");
                exitMenu.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        System.exit(0);
                    }
                });
                pm.add(changeUserMenu);
                pm.addSeparator();
                pm.add(exitMenu);
                TrayIcon ti = new TrayIcon(new ImageIcon(getClass().getResource("/Presentation/tray-icon-16.png")).getImage(), "JFlowMonitor", pm);
                ti.setImageAutoSize(true);
                st.add(ti);
                m_trayIcon = ti;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    void onStaticsShow() {
        SmallWindow.onStaticsShow();
    }

}
