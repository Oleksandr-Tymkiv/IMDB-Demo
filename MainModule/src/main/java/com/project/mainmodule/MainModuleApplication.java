package com.project.mainmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({com.project.securitymodule.SecurityModuleApplication.class})
public class MainModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainModuleApplication.class, args);
    }

}
