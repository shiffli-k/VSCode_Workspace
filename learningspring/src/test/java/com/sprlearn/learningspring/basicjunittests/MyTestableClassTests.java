package com.sprlearn.learningspring.basicjunittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sprlearn.learningspring.learn.concepts.tryingout.learningunittests.MyTestableClass;

// The name of class should be the nameofclass being tested with a 'Tests' at the end
public class MyTestableClassTests { 

    private MyTestableClass testClass;

    @BeforeEach
    void setup(){
        this.testClass = new MyTestableClass(null);
    }

    // Using Core Junit
    @Test
    void givenOddNumber_whenIsEvenCalled_thenReturnFalse(){
        boolean expectedVal = false;
        boolean actualVal = this.testClass.isEven(1);
        
        // assertEquals(expectedVal, actualVal); // Basic JUnit5Style
        assertThat(actualVal).isFalse();
    }

    @Test
    void givenEvenNumber_whenIsEvenCalled_thenReturnTrue(){

        // assertTrue(this.testClass.isEven(2)); // Basic Junit5Style
        assertThat(this.testClass.isEven(2)).isTrue();
    }

    @Test
    void intentionalFailingTestCase(){

        // assertTrue(false, () -> "This test case was designed to fail!");
        assertThat(2)
            .withFailMessage("This testcase is failed intentionally")
            .isEqualTo(2);
    }
}
