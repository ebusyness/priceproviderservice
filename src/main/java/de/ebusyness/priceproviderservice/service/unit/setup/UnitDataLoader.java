package de.ebusyness.priceproviderservice.service.unit.setup;

import de.ebusyness.priceproviderservice.dataaccess.unit.entity.UnitEntity;
import de.ebusyness.priceproviderservice.service.commons.EntityService;
import de.ebusyness.priceproviderservice.service.setup.SetupDataLoader;
import de.ebusyness.priceproviderservice.service.setup.AbstractSetupDataLoader;
import de.ebusyness.priceproviderservice.service.unit.UnitEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UnitDataLoader extends AbstractSetupDataLoader<UnitEntity> implements SetupDataLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitDataLoader.class);

    @Autowired
    private UnitEntityService unitEntityService;

    @Autowired
    public UnitDataLoader(UnitEntityService entityService) {
        super(entityService);
    }


    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public void loadEssentialData() {
        String essentialData = getDataFolder() + "essential/units.json";
        importFile(essentialData);
    }

    @Override
    public void loadSampleData() {
        String sampleData = getDataFolder() + "sample/units.json";
        if( getSampleDataOn() ) {
            importFile(sampleData);
        }
    }

}