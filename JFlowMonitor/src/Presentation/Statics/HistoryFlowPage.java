/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Statics;

import java.awt.Component;
import java.awt.Label;

/**
 *
 * @author Kuziki
 */
public class HistoryFlowPage extends AbstractStaticsPage {

    @Override
    protected String doToString() {
        return "HistoryFlow";
    }

    @Override
    protected Component doGetWidget() {
        return new HistoryFlowPanel();
    }

}