package com.demoaop;

import com.demoaop.DAO.AccountDAO;
import com.demoaop.DAO.MembershipDAO;
import com.demoaop.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        Account newAccount = new Account("John Doe", "Gold");

        theMembershipDAO.addAccount();

        theAccountDAO.addAccount(newAccount, true);

    }
}
