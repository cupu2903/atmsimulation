package com.mitrais.ayr.service.impl;

import com.mitrais.ayr.dto.AccountDto;
import com.mitrais.ayr.mapper.ModelMapper;
import com.mitrais.ayr.persistence.dao.AccountDao;
import com.mitrais.ayr.persistence.domain.Account;
import com.mitrais.ayr.service.AccountService;
import com.mitrais.ayr.service.common.AbstractService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.util.*;

import static com.mitrais.ayr.security.SecurityConstants.EXPIRATION_TIME;
import static com.mitrais.ayr.security.SecurityConstants.SECRET;

public class AccountServiceImpl extends AbstractService<Account, String> implements AccountService {

    @Autowired
    AccountDao dao;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean checkBalance(Account acct, BigDecimal nominal) {
        BigDecimal subtract = acct.getBalance().subtract(nominal);
        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected PagingAndSortingRepository<Account, String> getDao() {
        return dao;
    }


    @Override
    public String createToken(Account userDb) {
        List<String> authorityStrs = Arrays.asList("ROLE_USER");

        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", authorityStrs);
        String token = Jwts.builder().setSubject(userDb.getAcctNo()).addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
        return token;
    }

    @Override
    public AccountDto asUserDto(String acctNo) {
        Account account = findByID(acctNo);
        return mapper.asUserDto(account);
    }


}
