package de.saxsys.calculator.swing.main;

import de.saxsys.calculator.swing.controller.CalculatorController;

/**
 * @author daniel.winter
 *
 */
public class Main {

	public static void main(String[] args) {
		CalculatorController controller = new CalculatorController();
		controller.initModel();
		controller.initGui();
	}
}
