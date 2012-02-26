package de.saxsys.calculator;

import java.text.NumberFormat;
import java.util.Locale;

public class Calculator {

	private static final String ERROR = "ERR";
	private static final String BLANK = "";

	private static final NumberFormat FORMAT;
	static {
		FORMAT = NumberFormat.getInstance(Locale.ENGLISH);
		FORMAT.setGroupingUsed(false);
	}

	private char lastOperation;
	private double lastValue = 0f;
	private String currentValue = BLANK;

	
	public String press(String button) {

		if (isDigitOrDot(button)) {
			currentValue += button;
			return format(parseDouble(currentValue)) + (".".equals(button)? "." : "");
		} 

		if (isOperation(button)) {

			double currentFloatValue = parseDouble(currentValue);
			switch (lastOperation) {
			case '*':
				lastValue *= currentFloatValue;
				break;
			case '/':
				if (0 == currentFloatValue) {
					return ERROR;
				}
				lastValue /= currentFloatValue;
				break;
			case '+':
				lastValue += currentFloatValue;
				break;
			case '-':
				lastValue -= currentFloatValue;
				break;
			default:
				lastValue = currentFloatValue;
			}

			lastOperation = button.charAt(0);
			currentValue = BLANK;

			// using dot (.) as separator
			return format(lastValue);
		}

		if (button.equalsIgnoreCase("c")) {

			lastOperation = ' ';
			lastValue = 0f;
			currentValue = BLANK;

			return "0";
		}

		return ERROR;
	}

	private boolean isDigitOrDot(String button) {
		return button.matches("[.0-9]");
	}

	private boolean isOperation(String button) {
		return button.matches("[=*/+-]");
	}

	private double parseDouble(String number) {
		return Double
				.parseDouble((number.isEmpty()) ? "0" : number);
	}
	
	private String format(double number) {
		return FORMAT.format(number);
	}

}