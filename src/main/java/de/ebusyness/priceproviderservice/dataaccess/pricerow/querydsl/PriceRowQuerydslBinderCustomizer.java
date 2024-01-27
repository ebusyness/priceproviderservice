package de.ebusyness.priceproviderservice.dataaccess.pricerow.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import de.ebusyness.priceproviderservice.dataaccess.pricerow.entity.QPriceRowEntity;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

public interface PriceRowQuerydslBinderCustomizer extends QuerydslBinderCustomizer<QPriceRowEntity> {
    @Override
    default public void customize(QuerydslBindings bindings, QPriceRowEntity root) {
        bindings.bind(String.class).first((StringPath path, String value) -> path.eq(value));
        bindings.bind(root.priceValue)
                .all((NumberPath<BigDecimal> path, Collection<? extends BigDecimal> values) -> {
                    Iterator<? extends BigDecimal> it = values.iterator();
                    BigDecimal first = it.next();
                    if (values.size() >= 2) {
                        BigDecimal second = it.next();
                        return Optional.of(path.between(first, second));  // for range searches
                    } else {
                        return Optional.of(path.eq(first));  // otherwise eq
                    }
                });

        bindings.bind(root.validFrom).all((DateTimePath<Date> path, Collection<? extends Date> values) -> {
            Iterator<? extends Date> it = values.iterator();
            Date first = it.next();
            if (values.size() >= 2) {
                BooleanExpression isNull = path.isNull();
                BooleanExpression isBefore = path.before(first);
                return Optional.of(isNull.or(isBefore));
            } else {
                return Optional.of(path.eq(first).or(path.before(first)));
            }
        });

        bindings.bind(root.validTo).all((DateTimePath<Date> path, Collection<? extends Date> values) -> {
            Iterator<? extends Date> it = values.iterator();
            Date first = it.next();
            if (values.size() >= 2) {
                Date second = it.next();
                BooleanExpression isNull = path.isNull();
                BooleanExpression isAfter = path.after(first);
                return Optional.of(isNull.or(isAfter));
            } else {
                return Optional.of(path.eq(first).or(path.after(first)));
            }
        });

        bindings.excluding(root.id);
    }
}