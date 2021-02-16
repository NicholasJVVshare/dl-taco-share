package com.dl.tacoloco;

import static org.junit.jupiter.api.Assertions.*;

import com.dl.tacoloco.service.LocoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TacoLocoApplicationTests {
	private final boolean assertionCondition = true;

	@Autowired
	LocoService locoService;

	@Test
	void contextLoads() {
		assertTrue(assertionCondition);
	}

}
