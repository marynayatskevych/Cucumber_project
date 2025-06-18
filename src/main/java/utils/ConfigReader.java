package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
// This class is responsible for reading configuration properties from a file.
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties file.");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
