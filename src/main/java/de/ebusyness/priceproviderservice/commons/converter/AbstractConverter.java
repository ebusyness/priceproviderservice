package de.ebusyness.priceproviderservice.commons.converter;

import de.ebusyness.priceproviderservice.commons.converter.exception.DataConversionException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractConverter<SOURCE, TARGET> implements Converter<SOURCE, TARGET> {

    @Override
    public TARGET convert(SOURCE source) throws DataConversionException {
        TARGET target = createNew();
        convert(source, target);
        return target;
    }

    @Override
    public Collection<TARGET> convert(Collection<SOURCE> sourceItems) throws DataConversionException {
        List<TARGET> targetItems = new ArrayList<>();
        if (sourceItems == null) {
            return targetItems;
        }
        for (SOURCE sourceItem : sourceItems) {
            TARGET convert = convert(sourceItem);
            targetItems.add(convert);
        }
        return targetItems;
    }

    protected abstract TARGET createNew();
}