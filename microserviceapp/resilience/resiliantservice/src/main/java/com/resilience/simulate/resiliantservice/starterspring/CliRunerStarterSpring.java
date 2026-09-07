package com.resilience.simulate.resiliantservice.starterspring;

import java.time.Duration;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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

        // log.trace("Trying retry");
        // service.getWeatherInfo(null);

        // log.trace("Trying Rate Limiting");
        // IntStream.rangeClosed(1, 6)
        //     .forEach(eachInt -> 
        //         service.getWeatherInfo("City"+eachInt)
        //         // service.getWeatherInfo(null)
        //     );

        spammingBySecond();

        log.trace("-- Spring Starter CLI Runner Completed --");
        return;
    }

    private void spammingBySecond() {
        
        LongStream.rangeClosed(1, Long.MAX_VALUE)
        .forEach(
            eachVal ->{

                try {
                    Thread.sleep(Duration.ofSeconds(1));
                    this.service.testingProgramaticRateLimit(eachVal);
                } catch (InterruptedException e) {
                    log.error("Error at spammingBySecond(): " + e.getMessage());
                }
            } 
        );

    }


}
