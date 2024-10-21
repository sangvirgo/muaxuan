package com.sang.thefirstapp.common;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: "+ this.getClass().getSimpleName());
    }

    @Override // if you only have one contructor, you can omit @Autowired
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
