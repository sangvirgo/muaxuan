package com.demoaop.DAO;

import com.demoaop.entity.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipActive);
}
