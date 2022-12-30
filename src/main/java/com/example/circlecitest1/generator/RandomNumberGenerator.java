package com.example.circlecitest1.generator;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Component
public class RandomNumberGenerator {
	private final Random random = new Random();

	public int generateIntValue(int maxNumber) {
		var generatedValue = Math.abs(random.nextInt());

		return numberValidator(generatedValue, maxNumber);
	}

	private int numberValidator(int generatedValue, int maxValue) {
		if (generatedValue < maxValue) {
			return generatedValue;
		} else {
			List<Integer> integers = new ArrayList<>();
			while (generatedValue >= maxValue) {
				var val = generatedValue%10;
				integers.add(val);
				generatedValue = generatedValue/10;
			}
			generatedValue = integers.stream().reduce(0, Integer::sum);
			return numberValidator(generatedValue, maxValue);
		}
	}
}
