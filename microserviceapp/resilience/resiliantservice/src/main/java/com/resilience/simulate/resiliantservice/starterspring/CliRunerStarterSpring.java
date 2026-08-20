package com.resilience.simulate.resiliantservice.starterspring;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliRunerStarterSpring implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger("SpringStarterResiliance-CLIRUNNER");

    private ResiliantService service;
    
    public CliRunerStarterSpring(ResiliantService springProvidedServ){
        this.service = springProvidedServ;
    }

    @Override
    public void run(String... args) throws Exception {

        log.trace("--- Begin Execution of Spring Starter --");

        log.trace("Trying retry");
        service.getWeatherInfo(null);

        // log.trace("Trying Rate Limiting");
        // IntStream.rangeClosed(1, 6)
        //     .forEach(eachInt -> 
        //         service.getWeatherInfo("City"+eachInt)
        //         // service.getWeatherInfo(null)
        //     );


        log.trace("-- Spring Starter CLI Runner Completed --");
        return;
    }


}
