/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Statics;

import Logic.History.FlowHistoryInfo;
import java.awt.Component;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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
        Date beginD, endD;
        beginD = new Date(2, 1, 2);
        endD = new Date(2, 1, 3);
        FlowHistoryInfo hinfo = new FlowHistoryInfo(beginD, endD);

        DefaultPieDataset dataset = new DefaultPieDataset();
//        for (Map.Entry<Object, Object> m : hinfo.Data.entrySet()) {
//
//            System.out.println(m.getKey() + "---" + m.getValue());
//
//        }
//        Iterator<IPacket> it = packs.iterator();
//        while(it.hasNext()){
//
//        }
        dataset.setValue("WebSite 1", 0);
        dataset.setValue("WebSite 2", 27.9);
        dataset.setValue("WebSite 3", 79.5);
        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
                "WebSite Flow Analysis Chart",
                dataset,
                true, // legend?
                true, // tooltips?
                false // URLs?
                );

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }
}
