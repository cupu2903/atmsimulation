package com.mitrais.ayr.persistence.dao;

import com.mitrais.ayr.persistence.domain.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Achmad Yusuf Ramadhan Yusuf_AR91@mitrais.com
 * @version 0.4
 * @since 12/09/2019
 *
 * TransactionLogDao have functionality as an Interface to TransactionLog Repository
 *  * extend to JPA Repository in order to have all JPA Repository Behaviour
 *  * for modify query and other behaviour can be declare here
 *
 */
public interface TransactionLogDao extends JpaRepository<TransactionLog, String> {
}
