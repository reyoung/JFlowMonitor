/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Database.Database;
import Database.IDatabaseProxy;
import java.sql.SQLException;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Administrator
 */
public class PieChart {
    private DefaultPieDataset dataset = new DefaultPieDataset();
    private int flowFir;
    public PieChart(Date d){

    }
    public void Init(){

        dataset.setValue("WebSite 1", flowFir);
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
        // create and display a frame...
        ChartFrame frame = new ChartFrame("Test", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
