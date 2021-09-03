package main.model;

public class Pattern {

	public Pattern() {
		super();
	}

	public char[] getPatternZero() {
		char[] zero = new char[9];
		zero[0] = ' ';
		zero[1] = '_';
		zero[2] = ' ';

		zero[3] = '|';
		zero[4] = ' ';
		zero[5] = '|';

		zero[6] = '|';
		zero[7] = '_';
		zero[8] = '|';
		return zero;
	}

	public char[] getPatternOne() {
		char[] one = new char[9];
		one[0] = ' ';
		one[1] = ' ';
		one[2] = ' ';

		one[3] = ' ';
		one[4] = ' ';
		one[5] = '|';

		one[6] = ' ';
		one[7] = ' ';
		one[8] = '|';

		return one;
	}

	public char[] getPatternTwo() {
		char[] two = new char[9];
		two[0] = ' ';
		two[1] = '_';
		two[2] = ' ';

		two[3] = ' ';
		two[4] = '_';
		two[5] = '|';

		two[6] = '|';
		two[7] = '_';
		two[8] = ' ';
		return two;
	}

	public char[] getPatternThree() {
		char[] three = new char[9];
		three[0] = ' ';
		three[1] = '_';
		three[2] = ' ';

		three[3] = ' ';
		three[4] = '_';
		three[5] = '|';

		three[6] = ' ';
		three[7] = '_';
		three[8] = '|';
		return three;
	}

	public char[] getPatternFour() {
		char[] four = new char[9];

		four[0] = ' ';
		four[1] = ' ';
		four[2] = ' ';

		four[3] = '|';
		four[4] = '_';
		four[5] = '|';

		four[6] = ' ';
		four[7] = ' ';
		four[8] = '|';

		return four;
	}

	public char[] getPatternFive() {
		char[] five = new char[9];

		five[0] = ' ';
		five[1] = '_';
		five[2] = ' ';

		five[3] = '|';
		five[4] = '_';
		five[5] = ' ';

		five[6] = ' ';
		five[7] = '_';
		five[8] = '|';

		return five;
	}

	public char[] getPatternSix() {
		char[] six = new char[9];

		six[0] = ' ';
		six[1] = '_';
		six[2] = ' ';

		six[3] = '|';
		six[4] = '_';
		six[5] = ' ';

		six[6] = '|';
		six[7] = '_';
		six[8] = '|';

		return six;
	}

	public char[] getPatternSeven() {
		char[] seven = new char[9];

		seven[0] = ' ';
		seven[1] = '_';
		seven[2] = ' ';

		seven[3] = ' ';
		seven[4] = ' ';
		seven[5] = '|';

		seven[6] = ' ';
		seven[7] = ' ';
		seven[8] = '|';

		return seven;
	}

	public char[] getPatternEigth() {
		char[] eigth = new char[9];

		eigth[0] = ' ';
		eigth[1] = '_';
		eigth[2] = ' ';

		eigth[3] = '|';
		eigth[4] = '_';
		eigth[5] = '|';

		eigth[6] = '|';
		eigth[7] = '_';
		eigth[8] = '|';
		return eigth;
	}

	public char[] getPatternNine() {
		char[] nine = new char[9];
		nine[0] = ' ';
		nine[1] = '_';
		nine[2] = ' ';

		nine[3] = '|';
		nine[4] = '_';
		nine[5] = '|';

		nine[6] = ' ';
		nine[7] = '_';
		nine[8] = '|';
		return nine;
	}
}
