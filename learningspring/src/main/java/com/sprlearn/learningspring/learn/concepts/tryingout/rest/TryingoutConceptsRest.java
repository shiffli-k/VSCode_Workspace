package com.sprlearn.learningspring.learn.concepts.tryingout.rest;

import org.springframework.web.bind.annotation.RestController;

import com.sprlearn.learningspring.learn.concepts.basicannotations.FooBarInterface;
import com.sprlearn.learningspring.learn.concepts.beanscope.prototype.TrackerIDService;
import com.sprlearn.learningspring.learn.concepts.datajpa.entities.ProductEntity;
import com.sprlearn.learningspring.learn.concepts.datajpa.repos.ProductRepository;
import com.sprlearn.learningspring.learn.concepts.datajpa.service.ProductService;
import com.sprlearn.learningspring.learn.concepts.errorhandling.rest.IncorrectApiParameterException;
import com.sprlearn.learningspring.learn.concepts.properties.PropertiesComplex;
import com.sprlearn.learningspring.learn.concepts.properties.PropertiesSimple;
import com.sprlearn.learningspring.learn.concepts.properties.PropertiesSystem;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/rest")
@Lazy
public class TryingoutConceptsRest {

    private final FooBarInterface fb;
    private final TrackerIDService idServ;
    private final PropertiesSimple sProp;
    private final PropertiesSystem sysProp;
    private final PropertiesComplex compProp;
    private final ProductService productService;

    private final Logger log = LoggerFactory.getLogger(TryingoutConceptsRest.class);

    // Technically this is Autowired via Constructor Injection
    // @Autowired
    public TryingoutConceptsRest(
            @Qualifier(value = "bar") FooBarInterface fbImpl,
            TrackerIDService idServ,
            PropertiesSimple simplePropertiesObj,
            PropertiesSystem systemProperties,
            PropertiesComplex complxProp,
            ProductService productServiceBean
        ){
        this.fb = fbImpl;
        this.idServ = idServ;
        this.sProp = simplePropertiesObj;
        this.sysProp = systemProperties;
        this.compProp = complxProp;
        this.productService = productServiceBean;
        // log.error("Constructor Called");
    }

    @PostConstruct
    public void initialize(){
        log.error("Initialized");
    }

    @PreDestroy
    public void cleanup(){
        log.error("Destorying");
    }


    @GetMapping(path = "/")
    public ResponseEntity<String> base(@RequestParam(defaultValue = "none", name = "p") String param1) throws Exception {
        StringBuilder respMessage = new StringBuilder("Received: " + param1 + "\n");

        addMessageToBuilder(respMessage, fb.doSomething());

        // Trying out Prototype
        addMessageToBuilder(respMessage, idServ.getCorrectHandledTrackerID().getObject().toString());
        addMessageToBuilder(respMessage, idServ.getIncorrectHandledTrackerID().toString());

        // Trying out Simple PropertyValues
        addMessageToBuilder(respMessage, "--Simple Property values--");
        addMessageToBuilder(respMessage, sProp.toString());

        // Trying out System Properties
        addMessageToBuilder(respMessage, "--System Properties--");
        addMessageToBuilder(respMessage, sysProp.toString());

        // Trying out Complex Properties with Configurationproperties
        addMessageToBuilder(respMessage, "--Configurationproperties--");
        addMessageToBuilder(respMessage, compProp.prop1());
        addMessageToBuilder(respMessage, compProp.toString());

        // Controller Advice
        if("error".equals(param1)){
            // throw new Exception("The param p should not have value as error");
            throw new IncorrectApiParameterException("Request param p cannot have value as error");
        }

        return ResponseEntity.ok(respMessage.toString());
    }

    @GetMapping(path = "/jpa")
    public String getMethodName() {

        productService.tryingWithoutTransaction();

        return new String("Completed");
    }
    

    private void addMessageToBuilder(StringBuilder stringBuilderToAdd, String messageToAppend){
        stringBuilderToAdd.append("> " + messageToAppend + "\n");
        return;
    }
    
}
