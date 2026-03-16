package config;

import java.util.Properties;

public class ConfigReader {

    private static ThreadLocal<Properties> threadLocalProps = new ThreadLocal<>();

    static void setProperties(Properties properties) {
        if (properties == null) {
            throw new RuntimeException("Properties cannot be null");
        }
        threadLocalProps.set(properties);
    }

    private static Properties getProperties() {
        Properties props = threadLocalProps.get();
        if (props == null) {
            throw new RuntimeException("Environment properties not loaded. Call loadEnvironment() first.");
        }
        return props;
    }

    public static String get(String key) {
        String value = getProperties().getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in environment properties file");
        }
        return value;
    }
}
