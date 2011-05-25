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
public class DataCompressPage extends AbstractStaticsPage{
    @Override
    protected Component doGetWidget() {
        return new DataCompressPanel();
    }

    @Override
    protected String doToString() {
        return "History-Data Compress";
    }
}
