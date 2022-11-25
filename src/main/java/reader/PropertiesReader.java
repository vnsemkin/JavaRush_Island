package reader;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private final String FILE_EXTENSION = ".properties";
    private String propsFolder;
    private final Properties properties;

    public PropertiesReader(String propsFolder) {
        this.propsFolder = propsFolder;
        properties = new Properties();
    }

    public Properties loadProperties(String propertiesName) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream(propsFolder + "/" + propertiesName + FILE_EXTENSION);
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return properties;
    }
}
