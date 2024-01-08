package de.ebusyness.priceproviderservice.facade.pricerow.data;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class PriceRowData {
    private String pricedResourceId;
    private BigDecimal priceValue;
    private BigDecimal minQuantity;
    private String unitRef;
    private Currency currency;
    private Date validFrom;
    private Date validTo;
    private String customerId;
    private boolean taxIncluded;

    public String getPricedResourceId() {
        return pricedResourceId;
    }

    public void setPricedResourceId(String pricedResourceId) {
        this.pricedResourceId = pricedResourceId;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }

    public BigDecimal getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(BigDecimal minQuantity) {
        this.minQuantity = minQuantity;
    }

    public String getUnitRef() {
        return unitRef;
    }

    public void setUnitRef(String unitRef) {
        this.unitRef = unitRef;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isTaxIncluded() {
        return taxIncluded;
    }

    public void setTaxIncluded(boolean taxIncluded) {
        this.taxIncluded = taxIncluded;
    }

    @Override
    public String toString() {
        return "PriceRowData{" +
                "pricedResourceId='" + pricedResourceId + '\'' +
                ", priceValue=" + priceValue +
                ", minQuantity=" + minQuantity +
                ", unitRef='" + unitRef + '\'' +
                ", currency=" + currency +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", customerId='" + customerId + '\'' +
                ", taxIncluded=" + taxIncluded +
                '}';
    }
}