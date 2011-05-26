/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Presentation.Statics;

import java.awt.Component;

/**
 *
 * @author Reyoung
 */
public class TimeAttributePage extends AbstractStaticsPage{

    @Override
    protected String doToString() {
        return "Time Attribute Page";
    }

    @Override
    protected Component doGetWidget() {
        return new TimeAttributePanel();
    }

}
