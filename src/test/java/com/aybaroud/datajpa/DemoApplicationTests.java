package com.aybaroud.datajpa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	Calculator calculator = new Calculator();

	@Test
	void itShouldAddNumbers() {
		//given
		int numberOne = 20;
		int numberTwo = 30;

		//when
		int result = calculator.add(numberOne,numberTwo);

		// then
		int expected = 50;
		Assertions.assertThat(result).isEqualTo(expected);
	}

	class Calculator{
		int add(int a,int b){
			return a+b;
		}
	}
}
