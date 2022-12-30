package com.example.circlecitest1.controller;

import com.example.circlecitest1.generator.RandomNumberGenerator;
import com.example.circlecitest1.service.Randomizer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = {GeneratedValuesRestController.class })
public class GeneratedValuesRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@SpyBean
	private Randomizer randomizer;
	@MockBean
	private RandomNumberGenerator randomNumberGenerator;

	@Test
	void testGettingValues() throws Exception {
		when(randomNumberGenerator.generateIntValue(eq(100))).thenReturn(100);
		when(randomizer.randomize(1, 100)).thenReturn(List.of(100));

		mockMvc.perform(MockMvcRequestBuilders.get("/vals/generatedlist/1/100"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().json("[100]"));

		verify(randomNumberGenerator).generateIntValue(anyInt());
		verify(randomizer).randomize(1, 100);
	}
}