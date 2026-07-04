package com.sprlearn.learningspring.basicjunittests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sprlearn.learningspring.learn.concepts.tryingout.learningunittests.MyDepdendentClass;
import com.sprlearn.learningspring.learn.concepts.tryingout.learningunittests.MyTestableClass;

@ExtendWith(MockitoExtension.class)
public class MyTestableClassMockTests {

    @Mock
    private MyDepdendentClass dependency4TestClass;
    
    @InjectMocks
    private MyTestableClass testClass;

    @Test
    void returnsTrue_IfEvenPassed(){
        when(dependency4TestClass.isEven_Dependent(anyInt()))
            .thenReturn(true);

        assertThat(this.testClass.isEvenExternal(22))
            .isTrue();
    }
}
