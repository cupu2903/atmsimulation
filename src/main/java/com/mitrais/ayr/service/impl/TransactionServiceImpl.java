package com.mitrais.ayr.service.impl;

import com.mitrais.ayr.persistence.dao.TransactionLogDao;
import com.mitrais.ayr.persistence.domain.TransactionLog;
import com.mitrais.ayr.service.TransactionService;
import com.mitrais.ayr.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;


public class TransactionServiceImpl extends AbstractService<TransactionLog,String> implements TransactionService {

    @Autowired
    TransactionLogDao dao;

    @Override
    protected PagingAndSortingRepository<TransactionLog, String> getDao() {
        return dao;
    }
}
