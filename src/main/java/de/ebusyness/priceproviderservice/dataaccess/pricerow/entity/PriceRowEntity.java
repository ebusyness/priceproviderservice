package de.ebusyness.priceproviderservice.dataaccess.pricerow.entity;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class PriceRowEntity {
    private BigDecimal minQuantity;
    private String unit;
    private BigDecimal priceValue;
    private Currency currency;
    private Date validFrom;
    private Date validTo;
    private String cutomerId;
    private boolean net;
}