/*
 * This file is written by reyoung, reyoung@126.com.
 */

package Presentation.Statics;

import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author Reyoung
 */
public abstract  class AbstractStaticsPage implements IStaticsPage{

    private Component instance = null;

    public Component getWidget() {
        if(instance==null){
            instance = doGetWidget();
        }
        return instance;
    }

    @Override
    public String toString(){
        return this.doToString();
    }
    abstract protected String    doToString();
    abstract protected Component doGetWidget();
}
