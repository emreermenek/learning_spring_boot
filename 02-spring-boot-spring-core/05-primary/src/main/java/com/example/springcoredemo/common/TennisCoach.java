package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //since there are multiple implementations... we are making TrackCoach as the Primary coach
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "practice tennis";
    }
}
