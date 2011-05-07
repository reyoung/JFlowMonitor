/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Network.IPacket;
import Network.Packet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.JDBC;
/**
 *
 * @author Kuziki
 */
public class Database implements IDatabaseProxy{
    public Database()
    {
        try {
            conn = getConn();
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void savePacket(IPacket[] p)
    {
        if(p.length != 10)return;
        try {
            Statement stat = conn.createStatement();
            Date[] rdate = new Date[10];
            int[] sip = new int[10];
            int[] dip = new int[10];
            int[] sport = new int[10];
            int[] dport = new int[10];
            int[] size = new int[10];
            int[] flag = new int[10];
            boolean[] UpOrDown = new boolean[10];
            String[] insertSql = new String[10];
            for(int i=0 ; i<10 ; ++i)
            {
                rdate[i] = p[i].getPacketRecvTime();
                /*try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                sip[i] = p[i].getSourceAddress();
                dip[i] = p[i].getDestAddress();
                sport[i] = p[i].getSourcePort();
                dport[i] = p[i].getDestPort();
                size[i] = p[i].getPacketLength();
                flag[i] = p[i].getPacketFlag();
                UpOrDown[i] = p[i].isUpload();
                insertSql[i] = "insert into Detail values(";
                insertSql[i] += Long.toString(rdate[i].getTime());
                insertSql[i] += ",";
                insertSql[i] += Integer.toString(sip[i]);
                insertSql[i] += ",";
                insertSql[i] += Integer.toString(dip[i]);
                insertSql[i] += ",";
                insertSql[i] += Integer.toString(sport[i]);
                insertSql[i] += ",";
                insertSql[i] += Integer.toString(dport[i]);
                insertSql[i] += ",";
                insertSql[i] += Integer.toString(size[i]);
                insertSql[i] += ",";
                int t = ((UpOrDown[i]) ? 1 : 0);
                insertSql[i] += Integer.toString(t);
                insertSql[i] += ",";
                insertSql[i] += Integer.toString(flag[i]);
                insertSql[i] += ")";
                stat.addBatch(insertSql[i]);
            }
            stat.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Packet> checkDatetoDate(Date from,Date to) throws SQLException
    {
        Statement stat = conn.createStatement();
        Long fd = from.getTime();
        Long td = to.getTime();
        String sqlQuery = "select * from detail where PRecvTime > ";
        sqlQuery += Long.toString(fd);
        sqlQuery += " and PRecvTime < ";
        sqlQuery += Long.toString(td);
        ResultSet rs = stat.executeQuery(sqlQuery);
        List< Packet > p = new ArrayList< Packet >();
        while(rs.next())
        {
            Packet pack = new Packet();
            Date d = new Date();
            d.setTime(rs.getLong(1));
            pack.RecvTime = d;
            pack.SIP = rs.getInt(2);
            pack.DIP = rs.getInt(3);
            pack.SPort = rs.getInt(4);
            pack.DPort = rs.getInt(5);
            pack.PackLen = rs.getInt(6);
            pack.IsUpdate = rs.getBoolean(7);
            pack.PacketFlag = rs.getInt(8);
            p.add(pack);
        }
        rs.close();
        return p;
    }
    public List<Packet> checkDate(Date cdate) throws SQLException
    {
        int year = cdate.getYear();
        int month = cdate.getMonth();
        int day = cdate.getDate();
        int tday = day+1;
        Date from  = new Date(year,month,day);
        Date to = new Date(year,month,tday);
        return checkDatetoDate(from, to);
    }
    private static String url="org.sqlite.JDBC";
    private static String dri="jdbc:sqlite:flow.sqlite";
    public static Connection getConn() throws Exception
    {
        Class.forName(url);
        Connection conn = DriverManager.getConnection(dri);
        return conn;
    }
    public void Closedb() throws SQLException
    {
        conn.close();
    }
    private static Connection conn;
}
