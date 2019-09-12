package com.mitrais.ayr.service.impl;

import com.mitrais.ayr.persistence.dao.ATMServiceDAO;
import com.mitrais.ayr.persistence.domain.ATMService;
import com.mitrais.ayr.service.ATMServiceSvc;
import com.mitrais.ayr.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @since 12/09/2019
 */
public class ATMServiceSvcImpl extends AbstractService<ATMService,String> implements ATMServiceSvc {
    @Autowired
    ATMServiceDAO dao;
    @Override
    protected PagingAndSortingRepository<ATMService, String> getDao() {
        return dao;
    }
}
