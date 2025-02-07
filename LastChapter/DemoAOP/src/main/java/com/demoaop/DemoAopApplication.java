package com.demoaop;

import com.demoaop.DAO.AccountDAO;
import com.demoaop.DAO.MembershipDAO;
import com.demoaop.entity.Account;
import com.demoaop.service.TrafficService;
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
    public CommandLineRunner commandLineRunner(
                                                AccountDAO theAccountDAO,
                                                MembershipDAO theMembershipDAO,
                                                TrafficService theTrafficService) {
        return runner -> {
//            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

//            demoAfterReturningAdvice(theAccountDAO);

//            demoTheAfterThrowingAdvice(theAccountDAO);

//            demoTheAfterAdvice(theAccountDAO);

//            demoTheArroundAdvice(theTrafficService);

            demoTheAroundAdviceHandleException(theTrafficService);
        };
    }

    private void demoTheAroundAdviceHandleException(TrafficService theTrafficService) {
        System.out.println("----Main----The main program: demoArroundAdvice");
        System.out.println("----Main----Calling the getFortune()");

        String data=theTrafficService.getFortune(false);

        System.out.println("----Main----Result: "+data);
        System.out.println("----Main----Finished");
    }

    private void demoTheArroundAdvice(TrafficService theTrafficService) {
        System.out.println("----Main----The main program: demoArroundAdvice");
        System.out.println("----Main----Calling the getFortune()");
        String data=theTrafficService.getFortune();
        System.out.println("----Main----Result: "+data);
        System.out.println("----Main----Finished");
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts=null;

        try {
            boolean trip=true;
            theAccounts=theAccountDAO.findAccount(trip);
        }
        catch (Exception e) {
            System.out.println("\nMain program: ... caught exception: "+ e);
        }

        System.out.println("The main program: demoAfterReturningAdvice");
        System.out.println("-----------------------------------------------");
        System.out.println(theAccounts);
        System.out.println("-----------------------------------------------");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts=null;

        try {
            boolean trip=true;
            theAccounts=theAccountDAO.findAccount(trip);
        }
        catch (Exception e) {
            System.out.println("\nMain program: ... caught exception: "+ e);
        }

        System.out.println("The main program: demoAfterReturningAdvice");
        System.out.println("-----------------------------------------------");
        System.out.println(theAccounts);
        System.out.println("-----------------------------------------------");
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
