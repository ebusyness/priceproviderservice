package de.ebusyness.priceproviderservice.service.commons;

public interface EntityService<T> {
    T save(T entity);

    Class<T> getTargetClass();
}