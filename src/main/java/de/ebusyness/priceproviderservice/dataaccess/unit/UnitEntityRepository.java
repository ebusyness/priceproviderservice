package de.ebusyness.priceproviderservice.dataaccess.unit;

import de.ebusyness.priceproviderservice.dataaccess.unit.entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitEntityRepository extends JpaRepository<UnitEntity, String> {
    // You can define custom queries or methods specific to UnitEntity if needed
}