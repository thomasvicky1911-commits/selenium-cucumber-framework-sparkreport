package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentManager {

    private static Properties properties = new Properties();

    public static void loadEnvironment(String env) {

        String filePath = "src/test/resources/config/" + env + ".properties";

        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
            ConfigReader.setProperties(properties);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load environment properties: " + env, e);
        }
    }

//    public static String getProperty(String key) {
//        return properties.getProperty(key);
//    }

    public static String getUrl() {
        return properties.getProperty("base.url");
    }
}
