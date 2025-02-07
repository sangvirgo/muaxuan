package com.demoaop.DAO;

import com.demoaop.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, boolean vipActive) {
        System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
        System.out.println("Account: " + theAccount);
    }

    @Override
    public String getName() {
        System.out.println(getClass() + "in getName");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + "in setName");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + "in getServiceCode");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "in setServiceCode");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccount() {
        List<Account> rs=new ArrayList<>();

        Account account1 = new Account("John Doe", "Gold");
        Account account2 = new Account("Jane Smith", "Silver");
        Account account3 = new Account("Jim Brown", "Platinum");

        // Pass the Account objects to the addAccount method
        rs.add(account1);
        rs.add(account2);
        rs.add(account3);

        return rs;
    }

    @Override
    public List<Account> findAccount(boolean trip) {
        if(trip) {
            throw new RuntimeException("No soup for you !!!!!!!!!!!!!!!");
        }

        List<Account> rs=new ArrayList<>();

        Account account1 = new Account("John Doe", "Gold");
        Account account2 = new Account("Jane Smith", "Silver");
        Account account3 = new Account("Jim Brown", "Platinum");

        // Pass the Account objects to the addAccount method
        rs.add(account1);
        rs.add(account2);
        rs.add(account3);

        return rs;
    }
}