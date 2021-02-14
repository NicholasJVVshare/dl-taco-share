package com.dl.tacoloco;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TacoLocoApplicationTests {
	private final boolean assertionCondition = true;

	@Test
	void contextLoads() {
		assertTrue(assertionCondition);
	}

}
