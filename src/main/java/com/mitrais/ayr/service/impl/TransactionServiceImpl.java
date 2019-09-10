package com.mitrais.ayr.service.impl;

import com.mitrais.ayr.model.domain.Transaction;
import com.mitrais.ayr.service.TransactionService;

import java.util.List;

import static com.mitrais.ayr.model.domain.TransactionData.*;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<Transaction> findAll() {
        return ltx;
    }

    @Override
    public Transaction findByID(String s) {
        int index = ltx.indexOf(s);
        if (index == -1) {
            return null;
        } else {
            return ltx.get(index);
        }
    }

    @Override
    public Transaction create(Transaction entity) {
        if (ltx.add(entity)) {
            return entity;
        } else {
            return null;
        }
    }

    @Override
    public Transaction update(Transaction entity) {
        return null;
    }

    @Override
    public void delete(Transaction entity) {
        ltx.remove(entity);
    }

    @Override
    public void deleteById(String entityId) {

    }
}
