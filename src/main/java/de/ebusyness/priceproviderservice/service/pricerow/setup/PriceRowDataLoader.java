package de.ebusyness.priceproviderservice.service.pricerow.setup;

import de.ebusyness.priceproviderservice.dataaccess.pricerow.entity.PriceRowEntity;
import de.ebusyness.priceproviderservice.service.pricerow.PriceRowEntityService;
import de.ebusyness.priceproviderservice.service.setup.AbstractSetupDataLoader;
import de.ebusyness.priceproviderservice.service.setup.SetupDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceRowDataLoader extends AbstractSetupDataLoader<PriceRowEntity> implements SetupDataLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceRowDataLoader.class);

    @Autowired
    private PriceRowEntityService priceRowEntityService;

    @Value("${price-provider-service.initialize.entity.price-row.import-groups}")
    private List<String> importGroups;

    @Autowired
    public PriceRowDataLoader(PriceRowEntityService entityService) {
        super(entityService);
    }

    @Override
    public int getPriority() {
        return 200;
    }

    @Override
    public void loadEssentialData() {
        String essentialDataFolder = getDataFolder() + "essential/";
        for (String currency : importGroups) {
            importFile(essentialDataFolder + "price-rows." + currency + ".json");
        }
    }

    @Override
    public void loadSampleData() {
        String sampleDataFolder = getDataFolder() + "sample/";
        if (getSampleDataOn()) {
            for (String currency : importGroups) {
                importFile(sampleDataFolder + "price-rows." + currency + ".json");
            }
        }
    }

}