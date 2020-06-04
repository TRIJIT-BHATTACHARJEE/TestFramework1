package TestingFramework.Utility;

import java.io.FileReader;
import java.util.Properties;

public class ConfigPropertiesHelper {
    private static String configFileName = "src/test/resources/Config.properties";

    public static String getValueFromConfig(String key){
       String value="";
        try{
            FileReader reader=new FileReader(configFileName);

            Properties properties=new Properties();
            properties.load(reader);

            value=properties.getProperty(key);
        }catch(Exception e){
            e.printStackTrace();
        }
        return value;
    }

}
