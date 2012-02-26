package de.saxsys.calculator;

public class CalculatorApplication {
	
	public static void main(String[] args) {
		
		if (args.length > 0) {

			String result = "";
			Calculator calculator = new Calculator();
			char[] chars = args[0].toCharArray();
			for (int i = 0; i < chars.length; i++) {
				result = calculator.press(String.valueOf(chars[i]));				
			}
			System.out.println(result);
		}
	}
}
