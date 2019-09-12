package com.mitrais.ayr.service.common;

import com.google.common.collect.Lists;
import com.mitrais.ayr.persistence.IOperations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yusuf_AR91@mitrais.com
 * @version 0.4
 */
@Transactional
public abstract class AbstractService<T extends Serializable, ID> implements IOperations<T, ID> {
    @Override
    @Transactional(readOnly = true)
    public T findByID(ID id) {
        return getDao().findById(id).orElse(null);
    }

// read - all

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getDao().findAll(pageable);
    }

    @Override
    public Page<T> findPaginated(final int page, final int size) {
        return getDao().findAll(PageRequest.of(page, size));
    }

    // write

    @Override
    public T create(final T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(final ID entityId) {
        getDao().deleteById(entityId);
    }

    protected abstract PagingAndSortingRepository<T, ID> getDao();
}
