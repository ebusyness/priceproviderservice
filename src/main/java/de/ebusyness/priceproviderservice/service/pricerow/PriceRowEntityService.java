package de.ebusyness.priceproviderservice.service.pricerow;
import com.querydsl.core.types.Predicate;
import de.ebusyness.priceproviderservice.dataaccess.pricerow.PriceRowEntityRepository;
import de.ebusyness.priceproviderservice.facade.pricerow.data.PriceRowData;
import de.ebusyness.priceproviderservice.service.commons.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.ebusyness.priceproviderservice.dataaccess.pricerow.entity.PriceRowEntity;

import java.util.List;

@Service
public class PriceRowEntityService implements EntityService<PriceRowEntity> {

    private final PriceRowEntityRepository priceRowEntityRepository;

    @Autowired
    public PriceRowEntityService(PriceRowEntityRepository priceRowEntityRepository) {
        this.priceRowEntityRepository = priceRowEntityRepository;
    }

    @Override
    public Class<PriceRowEntity> getTargetClass() {
        return PriceRowEntity.class;
    }

    public PriceRowEntity save(PriceRowEntity priceRowEntity) {
        return priceRowEntityRepository.save(priceRowEntity);
    }

    public List<PriceRowEntity> findAll() {
        return priceRowEntityRepository.findAll();
    }

    public Iterable<PriceRowEntity> findPriceRows(Predicate predicate) {
        return priceRowEntityRepository.findAll(predicate);
    }
    public void deleteById(Long id) {
        priceRowEntityRepository.deleteById(id);
    }


}