package com.sprlearn.learningspring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprlearn.learningspring.learn.concepts.tryingout.learningunittests.MyTestableClass;

@SpringBootTest
class LearningspringApplicationTests {

	@Autowired
	private MyTestableClass MyTestClass;

	@Test
	void contextLoads() {
	}

	@Test
	void whenPassingEven_ReturnTrue(){
		assertThat(this.MyTestClass.isEvenExternal(2)).isTrue();
	}

}
