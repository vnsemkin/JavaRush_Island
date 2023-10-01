package util;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.util.Properties;

@Slf4j
public class PropertiesReader {

    public static Properties loadProperties(String propertiesName, String propsFolder) {
        Properties properties = new Properties();
        String FILE_EXTENSION = ".properties";
        String resourcePath = propsFolder + "/" + propertiesName + FILE_EXTENSION;
        log.info(resourcePath);
        try {
            properties.load(new FileInputStream(resourcePath));
            return properties;
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
