package com.itau.common.library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootTest(classes = BibliotecaComumParaOsMicrosservicosApplicationTests.TestConfig.class)
class BibliotecaComumParaOsMicrosservicosApplicationTests {

	@Test
	void contextLoads() {
	}

	@Configuration
	@AutoConfiguration
	static class TestConfig {
	}

}
