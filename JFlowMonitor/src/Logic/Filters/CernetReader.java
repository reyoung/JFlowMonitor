/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Filters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author YQ
 */
public class CernetReader {

    private String m_fileName = null;
    private List<CernetAttribute<String, String>> m_cernetAttributeList = null;

    public CernetReader(String fileName) {
        this.m_fileName = fileName;
        m_cernetAttributeList = new ArrayList<CernetAttribute<String, String>>();
        File file = new File(fileName);
        List list = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            //因为不知道有几行数据，所以先存入list集合中
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (IOException e) {
        }
        for (int i = 0; i < list.size(); i++) {
            CernetAttribute<String, String> ca = new CernetAttribute<String, String>();
            String changedString = list.get(i).toString();
            String[] strData = null;
            StringTokenizer strtoken = new StringTokenizer(changedString, " ");
            strData = new String[strtoken.countTokens()];
            int j = 0;
            while (strtoken.hasMoreTokens()) {
                strData[j] = strtoken.nextToken().trim();
                j++;
            }
            ca.ip = strData[0];
            ca.mask = strData[2];
            m_cernetAttributeList.add(ca);
        }
    }

    public List<CernetAttribute<String, String>> getCernetAttribute() {
        return m_cernetAttributeList;
    }
}
