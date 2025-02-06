package com.demoaop;

import com.demoaop.DAO.AccountDAO;
import com.demoaop.DAO.MembershipDAO;
import com.demoaop.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
//            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

            demoAfterReturningAdvice(theAccountDAO);
        };
    }

    private void demoAfterReturningAdvice(AccountDAO theAccountDAO) {
        List<Account> rs= theAccountDAO.findAccount();
        System.out.println("The main program: demoAfterReturningAdvice");
        System.out.println("-----------------------------------------------");
        System.out.println(rs);
        System.out.println("-----------------------------------------------");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        Account newAccount = new Account();

        theMembershipDAO.addAccount();

        theAccountDAO.addAccount(newAccount, true);

        theAccountDAO.setName("Sang");
        theAccountDAO.setServiceCode("Gia Su");

        String name=theAccountDAO.getName();
        String code=theAccountDAO.getServiceCode();

    }
}
