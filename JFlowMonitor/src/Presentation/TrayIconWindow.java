/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author YQ
 */
public class TrayIconWindow {
    public TrayIconWindow(){
        initComponents();
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
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void onStaticsShow() {
        if (m_mainWindow == null) {
            MainWindow wd = new MainWindow();
            wd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            m_mainWindow = wd;
        }
        m_mainWindow.setVisible(true);
    }
    private JFrame m_mainWindow = null;
}
