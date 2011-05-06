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
public interface ICernetReader {
    public List<CernetAttribute<String, String>> getCernetAttribute();
}
