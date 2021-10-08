package com.epam.engx.cleancode.naming.task3;

public class HarshadNumberSequenceProvider {

	private static final long SEQUENCE_LIMIT = 200;
	private static final String NEW_LINE = "\n";

	public String getSequence() {
		StringBuilder result = new StringBuilder();
		for (int currentNumber = 1; currentNumber <= SEQUENCE_LIMIT; currentNumber++) {
			if (isHarshad(currentNumber)) {
				result.append(currentNumber).append(NEW_LINE);
			}
		}
		return result.toString();
	}

	private boolean isHarshad(int number) {
		return number % getDigitsSum(number) == 0;
	}

	private int getDigitsSum(int number) {
		int sum = 0;
		while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
		return sum;
	}
}
