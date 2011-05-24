/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Administrator
 */
public class PieChart extends JPanel{
    private DefaultPieDataset dataset = new DefaultPieDataset();
    private int flowFir;
    public PieChart(){
        super(new BorderLayout());
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
//        ChartFrame frame = new ChartFrame("Test", chart);
//        frame.pack();
//        frame.setVisible(true);
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);
    }
   
}
