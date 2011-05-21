/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Presentation.Statics;

import java.awt.Component;
import java.awt.Label;

/**
 *
 * @author Reyoung
 */
public class TestPage2 extends AbstractStaticsPage {

    @Override
    protected String doToString() {
        return "Test Page 2";
    }

    @Override
    protected Component doGetWidget() {
        return new Label("Test Page 2");
    }

}
