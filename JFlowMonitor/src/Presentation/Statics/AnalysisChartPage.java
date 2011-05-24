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
public class AnalysisChartPage extends AbstractStaticsPage {

    @Override
    protected String doToString() {
        return "流量分析";
    }

    @Override
    protected Component doGetWidget() {

        //对应日期的流量分析
        //制作一个输入界面

        return new TimeSelectPage();
    }

}
