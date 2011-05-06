/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

/**
 *
 * @author Administrator
 */
public interface ILogicProxy {
    public class CurSpeed{
        public double CurIDSpeed;  //inner download
        public double CurODSpeed;  //outer download
        public double CurIUSpeed;  //inner upload
        public double CurOUSpeed;  //outer upload
    }
    CurSpeed speedReuqest();    //get the information of current speed
}
