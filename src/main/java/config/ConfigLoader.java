package config;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class ConfigLoader {
   protected static Properties properties;
public  static void  main(String [] args) throws IOException {
//    String baseDir = System.getProperty("user.dir");
//    String path = baseDir + "/src/test/resources/config/qa.properties";
//
//
//    FileInputStream fis = new FileInputStream(path);
//    Properties properties = new Properties();
//    properties.load(fis);
//
//    System.out.println(load("qa"));
//    System.out.println(ConfigLoader.getApplicationURL("browser"));
 load("qa");
    System.out.println(ConfigLoader.getkeys("browser"));
    System.out.println(ConfigLoader.getkeys("url"));



}



public  static  String load(String  env){
//    if (properties != null){
//        return properties.getProperty(env);
//    }

    properties = new Properties();
    String path = System.getProperty("user.dir") + "/src/test/resources/config/" + env + ".properties";
    try (FileInputStream fis = new FileInputStream(path)) {
        properties.load(fis);
        System.out.println("✅ Loaded config from: " + path);
    } catch (Exception e) {
        throw new RuntimeException("❌ Failed to load environment properties", e);
    }
    return properties.getProperty(env);
}

    public static String getkeys(String key) {

        if (properties == null) {
            throw new RuntimeException(
                    "❌ Properties not loaded. Call ConfigLoader.load(env) first."
            );
        }

        return properties.getProperty(key);
    }


}
