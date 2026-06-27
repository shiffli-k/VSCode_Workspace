package com.sprlearn.learningspring.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.sprlearn.learningspring.learn.concepts.lombok.RequestDTO;

@Component
public class CustomCliRunnerBean implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CustomCliRunnerBean.class);

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring booted gracefully! Here are some arguments!");
        for (String eachArgs : args)
            System.out.println("Arg: " + eachArgs);

        log.info(
            "Java Version: " + 
            System.getProperty("java.version")
            +"Running on: "+
            System.getProperty("os.name")
        );
        // RequestDTO obj = new RequestDTO();

    }

    private void doRequestOnurl(String Url) {
        System.out.println("\n\nDoing a HTTP Request");
        System.out.println(
                "Response: " +
                        RestClient
                                .create()
                                .get()
                                .uri("https://httpie.io/hello")
                                .retrieve()
                                .body(String.class));
        System.out.println("---Completed---\n\n");
    }
}
