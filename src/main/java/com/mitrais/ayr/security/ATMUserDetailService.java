package com.mitrais.ayr.security;

import com.mitrais.ayr.persistence.domain.Account;
import com.mitrais.ayr.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class ATMUserDetailService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account userDb = accountService.findByID(email);
        if (userDb == null) {
            throw new UsernameNotFoundException("No user found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(userDb.getAcctNo(), userDb.getPin(),
                true, true, true, true, accountService.getAuthorities(userDb.getAcctNo()));
    }

}
