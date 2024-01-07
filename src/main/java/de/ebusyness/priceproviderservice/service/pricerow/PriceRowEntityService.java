package de.ebusyness.priceproviderservice.service.pricerow;
import de.ebusyness.priceproviderservice.dataaccess.pricerow.PriceRowEntityRepository;
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

    public void deleteById(Long id) {
        priceRowEntityRepository.deleteById(id);
    }
}