package de.ebusyness.priceproviderservice.commons.converter;

import de.ebusyness.priceproviderservice.commons.converter.exception.DataConversionException;

import java.util.Collection;

public interface Converter<SOURCE, TARGET> {
    TARGET convert(SOURCE source) throws DataConversionException;

    void convert(SOURCE source, TARGET target) throws DataConversionException;

    Collection<TARGET> convert(Collection<SOURCE> sourceItems) throws DataConversionException;
}