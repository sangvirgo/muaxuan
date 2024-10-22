package com.sang.thefirstapp.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: "+ this.getClass().getSimpleName());
    }

//    define our init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("CricketCoach: inside method doMyStartupStuff");
    }

//    define our destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("CricketCoach: inside method doMyCleanupStuff");
    }

    @Override // if you only have one contructor, you can omit @Autowired
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
