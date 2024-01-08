package de.ebusyness.priceproviderservice.web.controller;

import de.ebusyness.priceproviderservice.commons.converter.exception.DataConversionException;
import de.ebusyness.priceproviderservice.facade.pricerow.PriceRowFacade;
import de.ebusyness.priceproviderservice.facade.pricerow.data.PriceRowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/pricerows")
public class PriceRowController {
    private final PriceRowFacade priceRowFacade;

    @Autowired
    public PriceRowController(PriceRowFacade priceRowFacade) {
        this.priceRowFacade = priceRowFacade;
    }

    @GetMapping
    public Collection<PriceRowData> getAllPriceRows() throws DataConversionException {
        return priceRowFacade.getAll();
    }
}