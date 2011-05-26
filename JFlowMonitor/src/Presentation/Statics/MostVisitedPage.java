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
public class MostVisitedPage extends AbstractStaticsPage{

    @Override
    protected String doToString() {
        return "Most Visited Site";
    }

    @Override
    protected Component doGetWidget() {
        return new MostVisitedPanel();
    }

}
