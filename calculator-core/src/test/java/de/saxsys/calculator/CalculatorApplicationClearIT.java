package de.saxsys.calculator;

import static de.saxsys.calculator.CalculatorItUtils.getOutput;
import static de.saxsys.calculator.CalculatorItUtils.runApplicationWithArgument;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorApplicationClearIT {
	
	@Test
	public void clearingSignClearsTheOutput() throws Exception {
		assertEquals("0", getOutput(runApplicationWithArgument("1+3C")));
	}
	
	@Test
	public void clearingSignResetTheState() throws Exception {
		assertEquals("2", getOutput(runApplicationWithArgument("1+3C+2=")));
	}
}
