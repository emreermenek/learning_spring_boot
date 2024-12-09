package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void doMyStartup(){
        System.out.println("In doMyStartup : " + getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void doMyCleanup(){
        System.out.println("In doMyCleanup : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "run a hard 5k";
    }
}
