package com.demoaop.service;


import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficServiceImpl implements TrafficService{

    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean trip) {
        if(trip) {
            throw new RuntimeException("----TrafficServiceImpl----Highway is closed!!!!!!!!!!!!!!!");
        }

        return getFortune();
    }
}
