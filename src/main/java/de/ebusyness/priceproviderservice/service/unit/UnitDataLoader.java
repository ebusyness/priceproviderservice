package de.ebusyness.priceproviderservice.service.unit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.ebusyness.priceproviderservice.dataaccess.unit.entity.UnitEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class UnitDataLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitDataLoader.class);

    @Autowired
    private UnitEntityService unitEntityService;

    @Value("${priceProviderService.initialize.dataFolder}")
    private String dataFolder;

    @PostConstruct
    public void loadUnitData() {
        try {
            String filePath = dataFolder + "units.json"; // Adjust the file name if needed

            Path path = Path.of(filePath);

            if (Files.exists(path)) {
                ObjectMapper objectMapper = new ObjectMapper();
                TypeReference<List<UnitEntity>> typeReference = new TypeReference<>() {};

                List<UnitEntity> units = objectMapper.readValue(Files.readString(path), typeReference);

                for (UnitEntity unit : units) {
                    unitEntityService.createUnit(unit);
                }

                LOGGER.info("Unit data loaded successfully.");
            } else {
                LOGGER.error("Unable to load unit data. File not found or empty.");
            }
        } catch (IOException e) {
            LOGGER.error("Error occurred while loading unit data: " + e.getMessage());
        }
    }
}