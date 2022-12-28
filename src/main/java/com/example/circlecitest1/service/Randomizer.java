package com.example.circlecitest1.service;

import com.example.circlecitest1.generator.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Randomizer {
	@Autowired
	private RandomNumberGenerator randomNumberGenerator;

	public List<Integer> randomize(int numberOfElems, int maxValue) {
		List<Integer> listOfGeneratedVals = new ArrayList<>();
		if (numberOfElems == maxValue) {
			throw new IllegalArgumentException("numbers shouldn't be equal");
		}

		while (!(listOfGeneratedVals.size() == numberOfElems)) {
			var val = randomNumberGenerator.generateIntValue(maxValue);
			if (!listOfGeneratedVals.contains(val)) {
				listOfGeneratedVals.add(val);
			}
		}
		return listOfGeneratedVals;
	}
}
