/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.PacketPool.IPacketPoolEvent;
import Logic.PacketPool.IPacketPoolEventListener;
import Logic.PacketPool.PacketPool;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

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
    private TimeSeries upload;
    private TimeSeries upinn;
    private TimeSeries upout;
    /** Time series for free memory. */
    private TimeSeries down;
    private TimeSeries dninn;
    private TimeSeries dnout;

    /**
     * Creates a new application.
     *
     * @param historyCount the history count (in milliseconds).
     */
    public TimeSeriesChart(int historyCount) {
        super(new BorderLayout());
// create two series that automatically discard data more than 30
// seconds old...
        this.upload = new TimeSeries("Upload", Millisecond.class);
        this.upload.setMaximumItemAge(historyCount);
        this.upinn = new TimeSeries("UpInner", Millisecond.class);
        this.upinn.setMaximumItemAge(historyCount);
        this.upout = new TimeSeries("UpOuter", Millisecond.class);
        this.upout.setMaximumItemAge(historyCount);
        this.down = new TimeSeries("Download", Millisecond.class);
        this.down.setMaximumItemAge(historyCount);
        this.dninn = new TimeSeries("DownInner", Millisecond.class);
        this.dninn.setMaximumItemAge(historyCount);
        this.dnout = new TimeSeries("DownOuter", Millisecond.class);
        this.dnout.setMaximumItemAge(historyCount);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(this.upload);
        dataset.addSeries(this.upinn);
        dataset.addSeries(this.upout);
        dataset.addSeries(this.down);
        dataset.addSeries(this.dninn);
        dataset.addSeries(this.dnout);
        DateAxis domain = new DateAxis("Time");
        NumberAxis range = new NumberAxis("Flow");
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
        range.setAutoRangeMinimumSize(10);
        range.setLowerBound(0);  
        domain.setLowerMargin(0.0);
        domain.setUpperMargin(0.0);
        domain.setTickLabelsVisible(true);
        range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        JFreeChart chart = new JFreeChart(
                "Flow observation",
                new Font("SansSerif", Font.BOLD, 24),
                plot,
                true);
        chart.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(4, 4, 4, 4),
                BorderFactory.createLineBorder(Color.black)));
        add(chartPanel);
//        for(int i=0;i<10;i++){
//            this.total.add(new Millisecond(), 0);
//            this.free.add(new Millisecond(), 0);
//        }
    }

    private void addUploadObservation(double y) {
        this.upload.add(new Millisecond(), y);
    }
    private void addUpinnObservation(double y) {
        this.upinn.add(new Millisecond(), y);
    }
    private void addUpoutObservation(double y) {
        this.upout.add(new Millisecond(), y);
    }

    /**
     * Adds an observation to the ’free memory’ time series.
     *
     * @param y the free memory.
     */
    private void addDownloadObservation(double y) {
        this.down.add(new Millisecond(), y);
    }
    private void addDowninnObservation(double y) {
        this.dninn.add(new Millisecond(), y);
    }
    private void addDownoutObservation(double y) {
        this.dnout.add(new Millisecond(), y);
    }

    /**
     * The data generator.
     */
    class DataGenerator extends Timer implements IPacketPoolEventListener {

        /**
         * Constructor.
         *
         * @param interval the interval (in milliseconds)
         */
        DataGenerator(int interval) {
            super(interval, null);
//            addActionListener(this);
            PacketPool.Instance().addPacketPoolListener(this);
//            for(int i=0;i<50;i++){
//                addUploadObservation(0);
//                addDownloadObservation(0);
//            }
        }

        /**
         * Adds a new free/total memory reading to the dataset.
         *
         * @param event the action event.
         */
//        public void actionPerformed(ActionEvent event) {
//            long f = Runtime.getRuntime().freeMemory();
//            long t = Runtime.getRuntime().totalMemory();
//            addUploadObservation(t);
//            addDownloadObservation(f);
//        }

        public void onPoolRefresh(IPacketPoolEvent e) {
            double us = e.getUploadSpeed()/1024;
            double ui = e.getInnerUploadSpeed()/1024;
            double uo = e.getOutterUploadSpeed()/1024;
            double ds = e.getDownloadSpeed()/1024;
            double di = e.getInnerDownloadSpeed()/1024;
            double dout = e.getOutterDownloadSpeed()/1024;
            addUploadObservation(us);
            addUpinnObservation(ui);
            addUpoutObservation(uo);
            addDownloadObservation(ds);
            addDowninnObservation(di);;
            addDownoutObservation(dout);
        }

        public boolean isEnable() {
            return true;
        }

        public boolean isConcern() {
            return true;
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
