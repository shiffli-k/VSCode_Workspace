package com.sprlearn.learningspring.learn.concepts.tryingout.clirunners;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.sprlearn.learningspring.learn.concepts.datajpa.entities.ProductEntity;
import com.sprlearn.learningspring.learn.concepts.datajpa.repos.ProductRepository;
import com.sprlearn.learningspring.learn.concepts.lombok.RequestDTO;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CustomCliRunnerBean implements CommandLineRunner {


    private ProductRepository productRepo;

    public CustomCliRunnerBean(ProductRepository prodRepoBean){
        this.productRepo = prodRepoBean;
    }


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

        log.info("Loading Temporary Values for Repo ");
        List<ProductEntity> prodList =  List.of(
            new ProductEntity(UUID.fromString("c4408a45-0ae3-4813-b8e7-2481189e05f3"), "Product1", 20.00D, "AED"),
            new ProductEntity(UUID.randomUUID(), "Product2", 10.00D, "AED"),
            new ProductEntity(UUID.randomUUID(), "Product3", 54.20D, "AED"),
            new ProductEntity(UUID.randomUUID(), "Product4", 94.55D, "AED"),
            new ProductEntity(UUID.randomUUID(), "Product5", 21.00D, "AED")
        );
        productRepo.saveAll(prodList);

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
