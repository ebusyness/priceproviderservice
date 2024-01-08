package de.ebusyness.priceproviderservice.facade.pricerow;

import de.ebusyness.priceproviderservice.commons.converter.exception.DataConversionException;
import de.ebusyness.priceproviderservice.dataaccess.pricerow.entity.PriceRowEntity;
import de.ebusyness.priceproviderservice.facade.pricerow.converter.PriceRowConverter;
import de.ebusyness.priceproviderservice.facade.pricerow.data.PriceRowData;
import de.ebusyness.priceproviderservice.service.pricerow.PriceRowEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PriceRowFacade {

    private final PriceRowConverter priceRowConverter;
    private final PriceRowEntityService priceRowService;

    @Autowired
    public PriceRowFacade(PriceRowConverter priceRowConverter, PriceRowEntityService priceRowService) {
        this.priceRowConverter = priceRowConverter;
        this.priceRowService = priceRowService;
    }

    public Collection<PriceRowData> getAll() throws DataConversionException {
        Collection<PriceRowEntity> priceRowEntities = priceRowService.findAll();
        return priceRowConverter.convert(priceRowEntities);
    }
}