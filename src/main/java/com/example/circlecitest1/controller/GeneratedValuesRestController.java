package com.example.circlecitest1.controller;

import com.example.circlecitest1.service.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vals")
public class GeneratedValuesRestController {
	@Autowired
	private Randomizer randomizer;
	private List<Integer> listOfGeneratedVals = new ArrayList<>();
	@GetMapping("/generatedlist/{numberOfElems}/{maxNumber}")
	public List<Integer> getGeneratedNums(@PathVariable int numberOfElems, @PathVariable int maxNumber) {
		return randomizer.randomize(numberOfElems, maxNumber);
	}
}
