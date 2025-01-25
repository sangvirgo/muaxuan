package com.demoaop.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccout() {
        System.out.println(getClass()+ " DOING MY DB");
    }
}
