package com.mitrais.ayr.service.impl;

import com.mitrais.ayr.persistence.dao.CIFDao;
import com.mitrais.ayr.persistence.domain.CIF;
import com.mitrais.ayr.service.CIFService;
import com.mitrais.ayr.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @since 12/09/2019
 */
public class CIFServiceImpl extends AbstractService<CIF, String> implements CIFService {
    @Autowired
    CIFDao dao;

    @Override
    protected PagingAndSortingRepository<CIF, String> getDao() {
        return dao;
    }
}
