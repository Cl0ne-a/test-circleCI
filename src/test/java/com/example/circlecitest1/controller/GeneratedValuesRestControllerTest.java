package com.example.circlecitest1.controller;

import com.example.circlecitest1.generator.RandomNumberGenerator;
import com.example.circlecitest1.service.Randomizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.management.MXBean;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
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
		when(randomizer.randomize(3, 10)).thenReturn(List.of(6, 4, 9));

		mockMvc.perform(MockMvcRequestBuilders.get("/vals/generatedlist/3/10"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().json("[6, 4, 9]"));

		verify(randomizer).randomize(3, 10);
	}
}