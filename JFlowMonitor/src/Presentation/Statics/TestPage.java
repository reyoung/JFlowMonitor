/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Presentation.Statics;

import Logic.History.MostVisitedSiteHistoryInfo;
import java.awt.Component;
import java.awt.Label;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reyoung
 */
public class TestPage extends AbstractStaticsPage{

    @Override
    protected Component doGetWidget() {
        QDateChooser q=new QDateChooser();
        Label l = new Label("Hello world");
        return q;
    }

    @Override
    protected String doToString() {
//        MostVisitedSiteHistoryInfo mvshi = new MostVisitedSiteHistoryInfo(new Date(111,4,15), new Date(111,4,22), 3);
//        mvshi.init();
        return "Test";
    }

}
