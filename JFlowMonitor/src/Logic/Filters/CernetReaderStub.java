/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.Filters;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YQ
 */
public class CernetReaderStub implements ICernetReader{
    public List<CernetAttribute<String, String>> getCernetAttribute(){
        List<CernetAttribute<String, String>> retv =new ArrayList<CernetAttribute<String, String>>();
        CernetAttribute<String, String> ca=new CernetAttribute<String, String>();
        ca.ip="1.51.0.0";
        ca.mask="255.255.0.0";
        retv.add(ca);
        CernetAttribute<String, String> cb=new CernetAttribute<String, String>();
        cb.ip="27.131.220.0";
        cb.mask="255.255.252.0";
        retv.add(cb);
        return retv;
    }
}
