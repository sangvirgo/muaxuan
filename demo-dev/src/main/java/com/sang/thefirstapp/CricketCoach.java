package com.sang.thefirstapp;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override // if you only have one contructor, you can omit @Autowired
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!!";
    }
}
