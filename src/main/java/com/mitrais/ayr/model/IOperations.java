package com.mitrais.ayr.model;

import java.io.Serializable;
import java.util.List;

public interface IOperations<T extends Serializable, ID> {

    List<T> findAll() ;
    T findByID(final ID id);
    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final ID entityId);
}
