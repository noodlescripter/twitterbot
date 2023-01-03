package lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class GetProp {
    

	public Properties prop;

    public GetProp(String filePath){
        BufferedReader buff = null;
        try {
           buff = new BufferedReader(new FileReader(filePath));
           prop = new Properties();
           prop.load(buff);
        } catch (Exception e) {
            System.out.println("Failed to read propeties file :::"+e.getMessage());
        }
    }

    public String getValue(String sValue) {
        return prop.getProperty(sValue);
    }
}
