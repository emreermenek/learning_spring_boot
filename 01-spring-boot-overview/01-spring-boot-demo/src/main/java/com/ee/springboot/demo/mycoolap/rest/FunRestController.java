package com.ee.springboot.demo.mycoolap.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //set up rest controller
public class FunRestController {

        // expose "/" that returns "Hello World"
        @GetMapping //handle HTTP Get request
        public String sayHello(){
            return "Hello World";
        }
}
