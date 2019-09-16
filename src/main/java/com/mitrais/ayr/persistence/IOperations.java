package com.mitrais.ayr.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yusuf_AR91@mitrais.com
 * @version 0.4
 * @since 12/09/2019
 */
public interface IOperations<T extends Serializable, ID> {

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    Page<T> findPaginated(int page, int size);

    T findByID(final ID id);

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final ID entityId);
}
