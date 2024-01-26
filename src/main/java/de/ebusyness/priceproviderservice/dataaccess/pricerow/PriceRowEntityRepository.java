package de.ebusyness.priceproviderservice.dataaccess.pricerow;

import de.ebusyness.priceproviderservice.dataaccess.pricerow.entity.PriceRowEntity;
import de.ebusyness.priceproviderservice.dataaccess.pricerow.querydsl.PriceRowQuerydslBinderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRowEntityRepository extends JpaRepository<PriceRowEntity, Long>, ListQuerydslPredicateExecutor<PriceRowEntity>, PriceRowQuerydslBinderCustomizer {
}