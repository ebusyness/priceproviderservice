package de.ebusyness.priceproviderservice.dataaccess.unit.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Map;

@Entity
public class UnitEntity {
    @Id
    private String symbol;
    // Use a Map to store name/language pairs
    @ElementCollection
    @CollectionTable(name = "unit_localized_names", joinColumns = @JoinColumn(name = "symbol"))
    @MapKeyColumn(name = "language_code")
    @Column(name = "name")
    private Map<String, String> name;

    private String measure;
    private String baseUnit;
    private BigDecimal factor;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "UnitEntity{" +
                "symbol='" + symbol + '\'' +
                ", name=" + name +
                ", measure='" + measure + '\'' +
                ", baseUnit='" + baseUnit + '\'' +
                ", factor=" + factor +
                '}';
    }
}