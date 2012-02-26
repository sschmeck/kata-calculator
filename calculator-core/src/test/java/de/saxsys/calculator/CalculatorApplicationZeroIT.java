package de.saxsys.calculator;

import static de.saxsys.calculator.CalculatorItUtils.getOutput;
import static de.saxsys.calculator.CalculatorItUtils.runApplicationWithArgument;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Checks the behavior of zero input.
 */
public class CalculatorApplicationZeroIT {

	@Test
	public void startingWithZeroWillBeIgnored() throws Exception {
		assertEquals("0", getOutput(runApplicationWithArgument("00")));
	}
	
	@Test
	public void startingZerosWillBeIgnored() throws Exception {
		assertEquals("1", getOutput(runApplicationWithArgument("001")));
	}
	
	@Test
	public void leadingZerosWillBeIgnored() throws Exception {
		assertEquals("5", getOutput(runApplicationWithArgument("4+001=")));
	}
	
	@Test
	public void additionWithZeroIsSupported() throws Exception {
		assertEquals("1", getOutput(runApplicationWithArgument("1+0=")));
	}
	
	@Test
	public void substractionWithZeroIsSupported() throws Exception {
		assertEquals("1", getOutput(runApplicationWithArgument("1-0=")));
	}
	
	@Test
	public void multiplicationWithZeroIsSupported() throws Exception {
		assertEquals("0", getOutput(runApplicationWithArgument("5*0=")));
	}
	
	@Test
	public void divisionWithZeroIsAnError() throws Exception {
		assertEquals("ERR", getOutput(runApplicationWithArgument("5/0=")));
	}
}