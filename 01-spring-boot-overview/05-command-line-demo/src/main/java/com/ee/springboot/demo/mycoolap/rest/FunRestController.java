package com.ee.springboot.demo.mycoolap.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //set up rest controller
public class FunRestController {

        // expose "/" that returns "Hello World"
        @GetMapping("/") //handle HTTP Get request
        public String sayHello(){
            return "Hello World";
        }

        // expose "/workout" that returns "run a hard 5k"
        @GetMapping("/workout")
        public String getDailyWorkout(){
             return "run a hard 5k";
        }

        // expose "/fortune" that returns "today is your lucky day"

        @GetMapping("/fortune")
        public String getDailyFortune(){
            return "today is your lucky day";
        }
}
