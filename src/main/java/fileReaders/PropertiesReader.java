package fileReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {

    static String currentDirectory = System.getProperty("user.dir");
    public String localFilePath = currentDirectory+"/src/application.properties";
    public String jenkinsFilePath ="";
    Properties properties;
    File file;
    String baseUrl;

    public PropertiesReader() {
        System.out.println(localFilePath);
        properties = new Properties();
        try {
            file = new File(jenkinsFilePath);
            System.out.println(file.exists());
            if (file.exists()) {
                properties.load(new FileInputStream(file));

            } else {
                file = new File(localFilePath);
                properties.load(new FileInputStream(file));

            }
        }catch (IOException fne){
            System.out.println("Not able to load file");
        }


        for (Object key : properties.keySet())
        {
            System.out.println(key.toString());
            System.setProperty(key.toString(),properties.getProperty(key.toString()));

        }
        setProperty();

    }

    public void setProperty(){
        baseUrl = System.getProperty("baseUrl");
        System.out.println(baseUrl);
    }

    public static void main(String[] args) {

        PropertiesReader propertiesReader = new PropertiesReader();
    }
}
