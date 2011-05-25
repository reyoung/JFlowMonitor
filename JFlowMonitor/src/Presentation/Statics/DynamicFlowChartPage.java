/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Statics;

import java.awt.Component;

/**
 *
 * @author Administrator
 */
public class DynamicFlowChartPage extends AbstractStaticsPage{

    @Override
    protected String doToString() {
        return "Realtime Flow Observation";
    }

    @Override
    protected Component doGetWidget() {
        TimeSeriesChartPanel panel = new TimeSeriesChartPanel(12000,true);
        panel.new DataGenerator(90).start();
        
        return panel;
    }

}
