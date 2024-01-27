package de.ebusyness.priceproviderservice.service.setup;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.ebusyness.priceproviderservice.service.commons.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TimeZone;

public class AbstractSetupDataLoader<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSetupDataLoader.class);


    private final EntityService<T> entityService;

    @Value("${price-provider-service.initialize.data-folder}")
    private String dataFolder;

    @Value("${price-provider-service.initialize.sample-data-on}")
    private Boolean sampleDataOn;

    public AbstractSetupDataLoader(EntityService<T> entityService) {
        this.entityService = entityService;
    }

    protected void importFile(String filePath) {
        try {
            Path path = Path.of(filePath);
            LOGGER.debug("Lookup data file {} ", filePath);
            if (Files.exists(path)) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());

                Class<T> targetClass = entityService.getTargetClass();
                JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, targetClass);
                List<T> entities = objectMapper.readValue(Files.readString(path), type);
                for (T entity : entities) {
                    entityService.save(entity);
                }
                LOGGER.info("Data file {} successfully imported.", filePath);
            } else {
                LOGGER.debug("Data file {} not found. Skipped.", filePath);
            }
        } catch (IOException e) {
            LOGGER.error("Error occurred while loading data: " + e.getMessage());
        }
    }

    protected String getDataFolder() {
        return dataFolder;
    }

    protected Boolean getSampleDataOn() {
        return sampleDataOn;
    }


}