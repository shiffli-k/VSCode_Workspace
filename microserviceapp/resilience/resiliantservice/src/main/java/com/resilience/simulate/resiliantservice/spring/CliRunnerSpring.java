package com.resilience.simulate.resiliantservice.spring;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CliRunnerSpring implements CommandLineRunner{

    private static Logger log = LoggerFactory.getLogger("CLI Runner");

    private ClientApiService clientApiServ;

    public CliRunnerSpring(ClientApiService springManagedClientApiServ){
        this.clientApiServ = springManagedClientApiServ;
    }

    @Override
    public void run(String... args) throws Exception {
        // IO.print("IN CLI RUNNER");

        try {


            // clientApiServ.getRespRetryable();
            // this.testConcurrent();


        } catch (Exception e) {
            log.error("Error caught by CLI Runner: " + e.getMessage());
            // log.error("Exception Thrown by CLI Runner: ", e);
        }
    }

    private void testConcurrent(){

        Runnable task = () -> {
            this.clientApiServ.limitedConcurrentRequest();
        };

        IntStream.range(0, 10)
            .forEach(eachVal -> {

                new Thread(task).start();

                return ;
            });
        
        log.info("All thread tasks started and completed");

        return;
    }

}
