/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Statics;

import Database.Flow;
import Logic.History.FlowHistoryInfo;
import Network.IPacket;
import java.awt.Color;
import java.awt.Component;
import java.awt.TextField;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Administrator
 */
public class AnalysisChart extends AbstractStaticsPage {

    @Override
    protected String doToString() {
        return "流量分析";
    }

    @Override
    protected Component doGetWidget() {

        //对应日期的流量分析
        //制作一个输入界面

        Date beginD, endD;
        beginD = new Date(111, 4, 20);
        endD = new Date(111, 4, 21);
        FlowHistoryInfo hinfo = new FlowHistoryInfo(beginD, endD);

        Map<Date, Flow> map = hinfo.Data;
        DefaultPieDataset dataset = new DefaultPieDataset();
        Iterator it = map.entrySet().iterator();
        int i = 0;
        System.out.println("come");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Date recv = (Date) entry.getKey();
            Flow f = (Flow) entry.getValue();
            dataset.setValue(recv+" InnerFlow", f.innerSize);
            dataset.setValue(recv+" OuterFlow", f.outerSize);
            System.out.println("Insert" + i);
        }
//        Date d=new Date();
//        System.out.println(""+d);
//        dataset.setValue(""+d, 27.9);
//        dataset.setValue("WebSite 3", 79.5);
        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart3D(
                "WebSite Flow Analysis Chart",
                dataset,
                true, // legend?
                true, // tooltips?
                false // URLs?
                );

        
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setForegroundAlpha(0.6f);
        plot.setCircular(true);
//        QDateChooser q=new QDateChooser();
//        q.setSize(200, 200);
//        q.setLocation(200, 200);
//        q.showInDialog();
//        chartPanel.add(q);
        ChartPanel chartPanel = new ChartPanel(chart);

        JPanel timePanel=new JPanel();
        TextField year = new TextField(4);
        TextField mounth = new TextField(2);
        TextField day = new TextField(2);
        timePanel.add(year);
        timePanel.add(mounth);
        timePanel.add(day);
        timePanel.setLocation(400, 400);

        chartPanel.add(timePanel);
        chartPanel.setLocation(200, 200);
        return chartPanel;
    }
}
