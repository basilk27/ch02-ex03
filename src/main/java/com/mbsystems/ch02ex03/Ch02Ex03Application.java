package com.mbsystems.ch02ex03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.mbsystems"})
public class Ch02Ex03Application {

    public static void main( String[] args ) {
        SpringApplication.run( Ch02Ex03Application.class, args );
    }

}
