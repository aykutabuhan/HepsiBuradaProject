package util;

import java.io.*;
import java.util.Properties;

public final class PropertyUtil {
    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";

    public static String getProperty(String propertyName, String fileName){
        Properties properties = null;
        try {
            properties = new Properties();
            BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_PATH+fileName));
            properties.load(reader);
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(propertyName);
    }
}