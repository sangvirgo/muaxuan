package com.sang.thefirstapp.rest;

import com.sang.thefirstapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//    define a private field for the dependency
    private Coach myCoach;


//    define a constructor for dependency injection
//    @Autowired
//    public DemoController(Coach theCoach) {
//        myCoach=theCoach;
//    }

//    define a setter method for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In constructor: "+ this.getClass().getSimpleName());
        myCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
