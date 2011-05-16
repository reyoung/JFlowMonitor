/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Administrator
 */
public class PieChart {

    public PieChart() {
        // create a dataset...
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("WebSite 1", 43.2);
        dataset.setValue("WebSite 2", 27.9);
        dataset.setValue("WebSitey 3", 79.5);
        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
                "WebSite Flow Analysis Chart",
                dataset,
                true, // legend?
                true, // tooltips?
                false // URLs?
                );
        // create and display a frame...
        ChartFrame frame = new ChartFrame("Test", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
