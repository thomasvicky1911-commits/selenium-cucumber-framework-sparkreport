package config;

import java.util.Properties;

public class ConfigReader {

    private static ThreadLocal<Properties> threadLocalProps = new ThreadLocal<>();

    static void setProperties(Properties properties) {
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
        return getProperties().getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }
}
