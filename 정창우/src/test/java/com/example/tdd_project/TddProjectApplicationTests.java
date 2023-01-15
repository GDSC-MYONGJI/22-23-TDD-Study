package com.example.tdd_project;

import com.example.tdd_project.chapter2.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TddProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void plus(){
		int result = Calculator.plus(1, 2);
		assertEquals(3, result);
		assertEquals(5, Calculator.plus(1, 4));
	}
}