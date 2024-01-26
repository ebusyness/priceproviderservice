package de.ebusyness.priceproviderservice.web.controller;

import com.querydsl.core.types.Predicate;
import de.ebusyness.priceproviderservice.commons.converter.exception.DataConversionException;
import de.ebusyness.priceproviderservice.dataaccess.pricerow.entity.PriceRowEntity;
import de.ebusyness.priceproviderservice.facade.pricerow.PriceRowFacade;
import de.ebusyness.priceproviderservice.facade.pricerow.data.PriceRowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pricerows")
public class PriceRowController {
    private final PriceRowFacade priceRowFacade;

    @Autowired
    public PriceRowController(PriceRowFacade priceRowFacade) {
        this.priceRowFacade = priceRowFacade;
    }


    @GetMapping
    public Iterable<PriceRowData> findByWebQuerydsl(@QuerydslPredicate(root = PriceRowEntity.class) Predicate predicate, Pageable pageable, @RequestParam MultiValueMap<String, String> parameters) throws DataConversionException {
        return priceRowFacade.findPriceRows(predicate);
    }
}