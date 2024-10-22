package com.sang.thefirstapp.config;


import com.sang.thefirstapp.common.Coach;
import com.sang.thefirstapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swim")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
