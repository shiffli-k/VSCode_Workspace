package com.sprlearn.learningspring.learn.concepts;

import org.springframework.web.bind.annotation.RestController;

import com.sprlearn.learningspring.learn.concepts.basicannotations.BarImpl;
import com.sprlearn.learningspring.learn.concepts.basicannotations.FooBarInterface;
import com.sprlearn.learningspring.learn.concepts.basicannotations.FooImpl;

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

    // Technically this is Autowired via Constructor Injection
    public TryingoutConceptsRest(@Qualifier(value = "barImpl") FooBarInterface fbImpl){
        this.fb = fbImpl;
    }


    @GetMapping(path = "/")
    public ResponseEntity<String> base(@RequestParam(defaultValue = "none", name = "p") String param1) {
        StringBuilder respMessage = new StringBuilder("Received: " + param1 + "\n");

        addMessageToBuilder(respMessage, fb.doSomething());

        return ResponseEntity.ok(respMessage.toString());
    }

    private void addMessageToBuilder(StringBuilder stringBuilderToAdd, String messageToAppend){
        stringBuilderToAdd.append("> " + messageToAppend + "\n");
        return;
    }
    
}
