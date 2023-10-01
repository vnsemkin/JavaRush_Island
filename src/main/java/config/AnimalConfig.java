package config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import model.animal.Animal;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static config.IslandConstants.YAML_FILE_PATH;

@Slf4j
@Getter
public final class AnimalConfig {
    private static AnimalConfig INSTANCE;

    private AnimalConfig() {
    }

    public static AnimalConfig getINSTANCE() {
        if (INSTANCE == null) {
            if (INSTANCE == null) {
                INSTANCE = new AnimalConfig();
                return INSTANCE;
            }
        }
        return INSTANCE;
    }

    public Map<String, Animal> getAnimalsProps() {
        Map<String, Animal> animalsMap = new HashMap<>();
        Set<? extends Animal> animals = new HashSet<>();
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            animals = mapper.readValue(new File(YAML_FILE_PATH), new TypeReference<>() {
            });
        } catch (Exception e) {
            log.error("Error loading animals from YAML", e);
        }

        for (Animal animal : animals) {
            animalsMap.put(animal.getName()
                    , animal);
        }
        return animalsMap;
    }
}
