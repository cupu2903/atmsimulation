package com.mitrais.ayr.mapper;

import com.mitrais.ayr.dto.AccountDto;
import com.mitrais.ayr.dto.TransactionDto;
import com.mitrais.ayr.persistence.domain.Account;
import com.mitrais.ayr.persistence.domain.TransactionLog;
import fr.xebia.extras.selma.*;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL, withIoC = IoC.SPRING)
public interface ModelMapper {

    @Maps(withCustomFields = {
            @Field({"Account.namaProject", "AccountDto.projectName"}),
            @Field({"Account.namaProject", "AccountDto.projectName"}),})
    AccountDto asUserDto(Account acct);

    @Maps(withCustomFields = {
            @Field(value = {"TransactionLog.crtdt", "TransactionDto.crtdt"})})
    TransactionDto asTrxDto(TransactionLog transaksi);

}
