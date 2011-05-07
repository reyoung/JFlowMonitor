/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Administrator
 */
public class TimeSeriesChart extends JPanel {

    /** Time series for total memory used. */
    private TimeSeries total;
    /** Time series for free memory. */
    private TimeSeries free;

    /**
     * Creates a new application.
     *
     * @param historyCount the history count (in milliseconds).
     */
    public TimeSeriesChart(int historyCount) {
        super(new BorderLayout());
// create two series that automatically discard data more than 30
// seconds old...
        this.total = new TimeSeries("Total", Millisecond.class);
        this.total.setMaximumItemAge(historyCount);
        this.free = new TimeSeries("Free", Millisecond.class);
        this.free.setMaximumItemAge(historyCount);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(this.total);
        dataset.addSeries(this.free);
        DateAxis domain = new DateAxis("Time");
        NumberAxis range = new NumberAxis("Memory");
        domain.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        range.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        domain.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));
        range.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));
        XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.green);
        renderer.setStroke(
                new BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        XYPlot plot = new XYPlot(dataset, domain, range, renderer);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        domain.setAutoRange(true);
        domain.setLowerMargin(0.0);
        domain.setUpperMargin(0.0);
        domain.setTickLabelsVisible(true);
        range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        JFreeChart chart = new JFreeChart(
                "JVM Memory Usage",
                new Font("SansSerif", Font.BOLD, 24),
                plot,
                true);
        chart.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(4, 4, 4, 4),
                BorderFactory.createLineBorder(Color.black)));
        add(chartPanel);
    }

    private void addTotalObservation(double y) {
        this.total.add(new Millisecond(), y);
    }

    /**
     * Adds an observation to the ’free memory’ time series.
     *
     * @param y the free memory.
     */
    private void addFreeObservation(double y) {
        this.free.add(new Millisecond(), y);
    }

    /**
     * The data generator.
     */
    class DataGenerator extends Timer implements ActionListener {

        /**
         * Constructor.
         *
         * @param interval the interval (in milliseconds)
         */
        DataGenerator(int interval) {
            super(interval, null);
            addActionListener(this);
        }

        /**
         * Adds a new free/total memory reading to the dataset.
         *
         * @param event the action event.
         */
        public void actionPerformed(ActionEvent event) {
            long f = Runtime.getRuntime().freeMemory();
            long t = Runtime.getRuntime().totalMemory();
            addTotalObservation(t);
            addFreeObservation(f);
        }
    }

    /**
     * Entry point for the sample application.
     *
     * @param args ignored.
     */
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Memory Usage Demo");
//        TimeSeriesChart panel = new TimeSeriesChart(30000);
//        frame.getContentPane().add(panel, BorderLayout.CENTER);
//        frame.setBounds(200, 120, 600, 280);
//        frame.setVisible(true);
//        panel.new DataGenerator(100).start();
//        frame.addWindowListener(new WindowAdapter() {
//
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//    }
}
