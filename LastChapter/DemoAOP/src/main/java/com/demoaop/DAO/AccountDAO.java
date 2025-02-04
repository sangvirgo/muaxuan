package com.demoaop.DAO;

import com.demoaop.entity.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipActive);

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
