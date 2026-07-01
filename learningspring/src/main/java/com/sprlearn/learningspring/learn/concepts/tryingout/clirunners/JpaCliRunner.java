package com.sprlearn.learningspring.learn.concepts.tryingout.clirunners;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprlearn.learningspring.learn.concepts.datajpa.entities.ProductEntity;
import com.sprlearn.learningspring.learn.concepts.datajpa.repos.ProductRepository;
import com.sprlearn.learningspring.learn.concepts.datajpa.service.ProductService;


@Component
@Order(value = Ordered.LOWEST_PRECEDENCE)
public class JpaCliRunner implements CommandLineRunner{

    private final Logger log = LoggerFactory.getLogger(JpaCliRunner.class);

    private ProductService productServ;
    
    public JpaCliRunner(ProductService productServiceBean){
        this.productServ = productServiceBean;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("==JPA CLI Runner==");
        productServ.tryingWithoutTransaction();
        log.info("==JPA CLI Runner | END ==");

    }


}
