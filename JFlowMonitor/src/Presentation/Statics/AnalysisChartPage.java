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
        return "Flaw Analysis";
    }

    @Override
    protected Component doGetWidget() {

       
        return new TimeSelectPage();
    }

}
