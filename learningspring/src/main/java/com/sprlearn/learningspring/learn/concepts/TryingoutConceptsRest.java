package com.sprlearn.learningspring.learn.concepts;

import org.springframework.web.bind.annotation.RestController;

import com.sprlearn.learningspring.learn.concepts.basicannotations.BarImpl;
import com.sprlearn.learningspring.learn.concepts.basicannotations.FooBarInterface;
import com.sprlearn.learningspring.learn.concepts.basicannotations.FooImpl;
import com.sprlearn.learningspring.learn.concepts.beanscope.prototype.TrackerIDService;
import com.sprlearn.learningspring.learn.concepts.properties.PropertiesComplex;
import com.sprlearn.learningspring.learn.concepts.properties.PropertiesComplexConfig;
import com.sprlearn.learningspring.learn.concepts.properties.PropertiesSimple;
import com.sprlearn.learningspring.learn.concepts.properties.PropertiesSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/rest")
public class TryingoutConceptsRest {

    private final FooBarInterface fb;
    private final TrackerIDService idServ;
    private final PropertiesSimple sProp;
    private final PropertiesSystem sysProp;
    private final PropertiesComplex compProp;

    // Technically this is Autowired via Constructor Injection
    public TryingoutConceptsRest(@Qualifier(value = "bar") FooBarInterface fbImpl, TrackerIDService idServ, PropertiesSimple simplePropertiesObj, PropertiesSystem systemProperties, PropertiesComplex complxProp){
        this.fb = fbImpl;
        this.idServ = idServ;
        this.sProp = simplePropertiesObj;
        this.sysProp = systemProperties;
        this.compProp = complxProp;
    }


    @GetMapping(path = "/")
    public ResponseEntity<String> base(@RequestParam(defaultValue = "none", name = "p") String param1) {
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

        return ResponseEntity.ok(respMessage.toString());
    }

    private void addMessageToBuilder(StringBuilder stringBuilderToAdd, String messageToAppend){
        stringBuilderToAdd.append("> " + messageToAppend + "\n");
        return;
    }
    
}
