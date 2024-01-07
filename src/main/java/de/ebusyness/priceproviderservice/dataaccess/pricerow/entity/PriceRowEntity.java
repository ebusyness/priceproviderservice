package de.ebusyness.priceproviderservice.dataaccess.pricerow.entity;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

@Entity
public class PriceRowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal priceValue;
    private BigDecimal minQuantity;
    private UnitEntity unit;
    private Currency currency;
    private Date validFrom;
    private Date validTo;
    private String cutomerId;
    private boolean net;

    public BigDecimal getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(BigDecimal minQuantity) {
        this.minQuantity = minQuantity;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
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

    public String getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(String cutomerId) {
        this.cutomerId = cutomerId;
    }

    public boolean isNet() {
        return net;
    }

    public void setNet(boolean net) {
        this.net = net;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PriceRowEntity{" +
                "minQuantity=" + minQuantity +
                ", unit=" + unit +
                ", priceValue=" + priceValue +
                ", currency=" + currency +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", cutomerId='" + cutomerId + '\'' +
                ", net=" + net +
                '}';
    }
}