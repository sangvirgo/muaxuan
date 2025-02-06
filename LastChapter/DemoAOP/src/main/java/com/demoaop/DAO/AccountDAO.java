package com.demoaop.DAO;

import com.demoaop.entity.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipActive);

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccount();
}
