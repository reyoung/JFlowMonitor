/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Presentation.Statics;

import java.awt.Component;
import java.awt.Label;
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
        return "Test";
    }

}