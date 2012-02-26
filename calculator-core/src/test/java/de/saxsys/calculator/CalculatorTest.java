package de.saxsys.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void enterNothingReturnsERR() {
		assertEquals("result", "ERR", new Calculator().press(""));
	}

	@Test
	public void enterOneReturnsOne() {
		assertEquals("result", "1", new Calculator().press("1"));
	}

	@Test
	public void enterTwoReturnsTwo() {
		assertEquals("result", "2", new Calculator().press("2"));
	}

	@Test
	public void enterOneAndTwoReturnsTwelve() {
		assertEquals("result", //
				"12", pressButtons(new Calculator(), "1", "2"));
	}

	@Test
	public void enterOneAndPlusReturnsOne() {
		assertEquals("result", //
				"1", pressButtons(new Calculator(), "1", "+"));
	}

	@Test
	public void enterOneAndMinusReturnsOne() {
		assertEquals("result", //
				"1", pressButtons(new Calculator(), "1", "-"));
	}

	@Test
	public void enterOneAndPlusAndTwoReturnsTwo() {
		assertEquals("result", //
				"2", pressButtons(new Calculator(), "1", "+", "2"));
	}

	@Test
	public void enterOneAndMinusAndTwoReturnsTwo() {
		assertEquals("result", //
				"2", pressButtons(new Calculator(), "1", "-", "2"));
	}

	@Test
	public void enterOnePlusTwoEqualsReturnsThree() {
		assertEquals("result", //
				"3", pressButtons(new Calculator(), "1", "+", "2", "="));
	}

	@Test
	public void enterTwoMinusOneEqualsReturnsOne() {
		assertEquals("result", //
				"1", pressButtons(new Calculator(), "2", "-", "1", "="));
	}

	@Test
	public void enterOnePlusTwoPlusReturnsThree() {
		assertEquals("result", //
				"3", pressButtons(new Calculator(), "1", "+", "2", "+"));
	}

	@Test
	public void enterSixDividedByTwoEqualsReturnsThree() {
		assertEquals("result", //
				"3", pressButtons(new Calculator(), "6", "/", "2", "="));
	}

	@Test
	public void enterThreeMultipliedWithTwoEqualsReturnsThree() {
		assertEquals("result", //
				"6", pressButtons(new Calculator(), "3", "*", "2", "="));
	}

	@Test
	public void enterThreePlusTwoMinusOneEqualsReturnsFour() {
		assertEquals(
				"result", //
				"4",
				pressButtons(new Calculator(), "3", "+", "2", "-", "1", "="));
	}

	@Test
	public void enterOnePointReturnsOnePoint() {
		assertEquals("result", //
				"1.", pressButtons(new Calculator(), "1", "."));
	}

	@Test
	public void enterOnePointTwoReturnsOnePointTwo() {
		assertEquals("result", //
				"1.2", pressButtons(new Calculator(), "1", ".", "2"));
	}

	@Test
	public void enterOnePointTwoMinusOneEqualsReturnsZeroPointTwo() {
		assertEquals(
				"result", //
				"0.2",
				pressButtons(new Calculator(), "1", ".", "2", "-", "1", "="));
	}

	@Test
	public void enterOnePlusTwoClearReturnsZero() {
		assertEquals("result", //
				"0", pressButtons(new Calculator(), "1", "+", "2", "C"));
	}

	@Test
	public void enterOnePlusTwoClearEqualsReturnsZero() {
		assertEquals("result", //
				"0", pressButtons(new Calculator(), "1", "+", "2", "C", "="));
	}
	
	@Test
	public void enterZeroZeroReturnsZero() {
		assertEquals("result", //
				"0", pressButtons(new Calculator(), "0", "0"));
	}

	@Test
	public void enterZeroOneReturnsOne() {
		assertEquals("result", //
				"1", pressButtons(new Calculator(), "0", "1"));
	}
	
	@Test
	public void enterZeroTwoAfterOneAndPlusReturnsTwo() {
		assertEquals("result", //
				"2", pressButtons(new Calculator(), "1", "+", "0", "2"));
	}
	
	@Test
	public void enterOneDividedByZeroReturnsERR() {
		assertEquals("result", //
				"ERR", pressButtons(new Calculator(), "1", "/", "0", "="));
	}
	
	
	private String pressButtons(Calculator calculator, String... buttons) {
		int lastIndex = buttons.length - 1;
		for (int i = 0; i < lastIndex; i++) {
			calculator.press(buttons[i]);
		}
		return String.valueOf(calculator.press(buttons[lastIndex]));
	}
}
