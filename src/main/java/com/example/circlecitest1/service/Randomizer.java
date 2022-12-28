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

	public List<Integer> randomize(int numberOfElems, int maxNumber) {
		List<Integer> listOfGeneratedVals = new ArrayList<>();
		if (numberOfElems == maxNumber) {
			throw new IllegalArgumentException("numbers shouldn't be equal");
		}

		while (listOfGeneratedVals.size() < numberOfElems) {
			var val = randomNumberGenerator.generateIntValue(maxNumber);
			if (!listOfGeneratedVals.contains(val)) {
				listOfGeneratedVals.add(val);
			}
		}
		return listOfGeneratedVals;
	}
}
