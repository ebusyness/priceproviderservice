package de.ebusyness.priceproviderservice.dataaccess.pricerow.entity;

import de.ebusyness.priceproviderservice.dataaccess.unit.entity.UnitEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Currency;

@Entity
public class PriceRowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pricedResourceId;
    private BigDecimal priceValue;
    private BigDecimal minQuantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_symbol")
    private UnitEntity unit;
    private Currency currency;
    private OffsetDateTime validFrom;
    private OffsetDateTime validTo;
    private String customerId;
    private boolean taxIncluded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTaxIncluded() {
        return taxIncluded;
    }

    public void setTaxIncluded(boolean taxIncluded) {
        this.taxIncluded = taxIncluded;
    }

    public String getPricedResourceId() {
        return pricedResourceId;
    }

    public void setPricedResourceId(String pricedResourceId) {
        this.pricedResourceId = pricedResourceId;
    }

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

    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public OffsetDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Transient
    public String getUnitRef() {
        return unit.getSymbol();
    }

    @Transient
    public void setUnitRef(String unitRef) {
        UnitEntity unit = new UnitEntity();
        unit.setSymbol(unitRef);
        setUnit(unit);
    }

    @Override
    public String toString() {
        return "PriceRowEntity{" +
                "id=" + id +
                ", pricedResourceId='" + pricedResourceId + '\'' +
                ", priceValue=" + priceValue +
                ", minQuantity=" + minQuantity +
                ", unit=" + unit +
                ", currency=" + currency +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", customerId='" + customerId + '\'' +
                ", taxIncluded=" + taxIncluded +
                '}';
    }
}