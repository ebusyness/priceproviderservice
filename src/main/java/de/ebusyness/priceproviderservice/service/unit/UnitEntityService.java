package de.ebusyness.priceproviderservice.service.unit;

import de.ebusyness.priceproviderservice.dataaccess.unit.UnitEntityRepository;
import de.ebusyness.priceproviderservice.dataaccess.unit.entity.UnitEntity;
import de.ebusyness.priceproviderservice.service.commons.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Entity;

import java.util.List;
import java.util.Optional;

@Service
public class UnitEntityService implements EntityService<UnitEntity> {

    @Autowired
    private UnitEntityRepository unitEntityRepository;

    // Create operation
    @Override
    public Class<UnitEntity> getTargetClass() {
        return UnitEntity.class;
    }

    public UnitEntity save(UnitEntity unitEntity) {
        return unitEntityRepository.save(unitEntity);
    }

    // Read operations
    public List<UnitEntity> getAllUnits() {
        return unitEntityRepository.findAll();
    }

    public Optional<UnitEntity> getUnitBySymbol(String symbol) {
        return unitEntityRepository.findById(symbol);
    }

    // Update operation
    public UnitEntity updateUnit(UnitEntity updatedUnit) {
        return unitEntityRepository.save(updatedUnit);
    }

    // Delete operation
    public void deleteUnit(String symbol) {
        unitEntityRepository.deleteById(symbol);
    }
}