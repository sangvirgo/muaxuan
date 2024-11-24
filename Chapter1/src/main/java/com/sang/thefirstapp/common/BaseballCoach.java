package com.sang.thefirstapp.common;

import org.springframework.stereotype.Service;

@Service
public class BaseballCoach implements Coach{
    public BaseballCoach() {
        System.out.println("In constructor: "+ this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice hitting for 30 minutes";
    }
}
