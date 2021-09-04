package main.service;

import java.util.Arrays;

import main.model.PatternModel;

public class PatternService {

	PatternModel patterns = new PatternModel();

	public char getAccountNumber(char[] vectorParam) {
		return vectorCompare(vectorParam);
	}

	private char vectorCompare(char[] vectorTemp) {
		if (Arrays.equals(vectorTemp, patterns.getPatternZero()))
			return '0';
		if (Arrays.equals(vectorTemp, patterns.getPatternOne()))
			return '1';
		if (Arrays.equals(vectorTemp, patterns.getPatternTwo()))
			return '2';
		if (Arrays.equals(vectorTemp, patterns.getPatternThree()))
			return '3';
		if (Arrays.equals(vectorTemp, patterns.getPatternFour()))
			return '4';
		if (Arrays.equals(vectorTemp, patterns.getPatternFive()))
			return '5';
		if (Arrays.equals(vectorTemp, patterns.getPatternSix()))
			return '6';
		if (Arrays.equals(vectorTemp, patterns.getPatternSeven()))
			return '7';
		if (Arrays.equals(vectorTemp, patterns.getPatternEigth()))
			return '8';
		if (Arrays.equals(vectorTemp, patterns.getPatternNine()))
			return '9';
		return '?';
	}
}
