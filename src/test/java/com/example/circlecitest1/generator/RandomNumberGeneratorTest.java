package com.example.circlecitest1.generator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RandomNumberGeneratorTest {
	@Autowired
	private RandomNumberGenerator randomNumberGenerator;

	@Test
	void ctx() {
		assertNotNull(randomNumberGenerator);
	}

	@ParameterizedTest
	@ValueSource(ints = {46, 16, 61, 32, 54, 80, 443, 1000})
	public void testRandomNumberGenerator(int nextNumber) {
		int generaatedValue = randomNumberGenerator.generateIntValue(nextNumber);
		log.info(generaatedValue + " " + nextNumber);
		assertThat(generaatedValue).isLessThan(nextNumber);
	}
}