package de.saxsys.calculator;

import static de.saxsys.calculator.CalculatorItUtils.getOutput;
import static de.saxsys.calculator.CalculatorItUtils.runApplicationWithArgument;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Check the basic features.
 * <ul>
 * <li>supports digits from 0 till 9</li>
 * <li>supports addition ('+'), subtraction ('-'), multiplication ('*') and division ('/')</li>
 * </ul>
 */
public class CalculatorApplicationBasicIT {

	@Test
	public void supportDigitsFromZeroToNine() throws Exception {
		assertEquals("1234567890", getOutput(runApplicationWithArgument("1234567890")));
	}

	@Test
	public void supportAddtion() throws Exception {
		assertEquals("3", getOutput(runApplicationWithArgument("1+2=")));
	}

	@Test
	public void supportSubstraction() throws Exception {
		assertEquals("1", getOutput(runApplicationWithArgument("4-3=")));
	}

	@Test
	public void supportMultiplication() throws Exception {
		assertEquals("8", getOutput(runApplicationWithArgument("2*4=")));
	}

	@Test
	public void supportDivision() throws Exception {
		assertEquals("2", getOutput(runApplicationWithArgument("6/3=")));
	}

	@Test
	public void returnIntermediateResultWhenPressingOperation()
			throws Exception {
		assertEquals("2", getOutput(runApplicationWithArgument("6/3+")));
	}
}
