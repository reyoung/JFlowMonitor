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
public class DynamicFlowChart extends AbstractStaticsPage{

    @Override
    protected String doToString() {
        return "实时流量监控";
    }

    @Override
    protected Component doGetWidget() {
        TimeSeriesChart panel = new TimeSeriesChart(12000,true);
        panel.new DataGenerator(90).start();
        
        return panel;
    }

}
