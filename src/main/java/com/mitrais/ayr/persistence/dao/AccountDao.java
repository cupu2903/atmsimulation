package com.mitrais.ayr.persistence.dao;

import com.mitrais.ayr.persistence.domain.ATMService;
import com.mitrais.ayr.persistence.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Achmad Yusuf Ramadhan
 * @version 0.4
 * @since 12/09/2019
 *
 * AccountDAO have functionality as an Interface to Account Repository
 * extend to JPA Repository in order to have all JPA Repository Behaviour
 * for modify query and other behaviour can be declare here
 */
public interface AccountDao extends JpaRepository<Account, String> {
}
