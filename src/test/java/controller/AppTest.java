package controller;

import config.AnimalConfig;
import model.animal.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class AppTest {

    @Test
    public void loadPropertiesTest() {
        Properties properties = new Properties();
        String FILE_EXTENSION = ".properties";
        String resourcePath = "src/main/resources/inhabitantprops/bear.properties";
        try {
            FileInputStream inputStream = new FileInputStream(resourcePath);
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(properties);
    }

    @Test
    public void should_return_bear(){
        Map<String, Animal> animalsProps = AnimalConfig.getINSTANCE().getAnimalsProps();
        for (Map.Entry<String, Animal> entry  : animalsProps.entrySet()) {
            if(Objects.equals(entry.getKey(), "bear")) {
                System.out.println(entry.getKey() + " : " + entry.getValue().getName());
            }
        }
        System.out.println(animalsProps.get("bear").getFoodSaturation());
    }
}










