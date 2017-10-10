package com.xxjz;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class RunMain {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RunMain.class, args);
    }
}
