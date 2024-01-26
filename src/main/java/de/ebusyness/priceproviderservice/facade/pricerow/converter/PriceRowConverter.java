package de.ebusyness.priceproviderservice.facade.pricerow.converter;

import de.ebusyness.priceproviderservice.commons.converter.AbstractConverter;
import de.ebusyness.priceproviderservice.commons.converter.exception.DataConversionException;
import de.ebusyness.priceproviderservice.dataaccess.pricerow.entity.PriceRowEntity;
import de.ebusyness.priceproviderservice.facade.pricerow.data.PriceRowData;
import org.springframework.stereotype.Component;

@Component
public class PriceRowConverter extends AbstractConverter<PriceRowEntity, PriceRowData> {

    @Override
    public void convert(PriceRowEntity source, PriceRowData target) throws DataConversionException {
        target.setMinQuantity(source.getMinQuantity());
        target.setPriceValue(source.getPriceValue());
        target.setCurrency(source.getCurrency());
        target.setCustomerId(source.getCustomerId());
        target.setUnitRef(source.getUnitRef());
        target.setPricedResourceId(source.getPricedResourceId());
        target.setValidFrom(source.getValidFrom());
        target.setValidTo(source.getValidTo());
        target.setTaxIncluded(source.isTaxIncluded());
    }

    @Override
    protected PriceRowData createNew() {
        return new PriceRowData();
    }
}