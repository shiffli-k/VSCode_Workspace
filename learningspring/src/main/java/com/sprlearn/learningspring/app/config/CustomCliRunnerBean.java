package com.sprlearn.learningspring.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.sprlearn.learningspring.learn.concepts.lombok.RequestDTO;

@Component
public class CustomCliRunnerBean implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring booted gracefully! Here are some arguments!");
        for (String eachArgs : args)
            System.out.println("Arg: " + eachArgs);

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
