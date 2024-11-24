package com.sang.thefirstapp.common;

import org.springframework.stereotype.Service;

@Service
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("In constructor: "+ this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
