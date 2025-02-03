package com.demoaop.DAO;

import com.demoaop.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean vipActive) {
        System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
        System.out.println("Account: " + theAccount);
    }
}