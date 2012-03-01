package de.saxsys.calculator.swing.controller;

import de.saxsys.calculator.Calculator;
import de.saxsys.calculator.swing.gui.CalculatorGui;
import de.saxsys.calculator.swing.interfaces.ICalculatorGui;
import de.saxsys.calculator.swing.model.CalculatorModel;

/**
 * @author daniel.winter
 *
 */
public class CalculatorController {

	private Calculator calculator;
	private CalculatorGui calcGui;
	private CalculatorModel calcModel;
	
	public CalculatorController() {
		this.calcModel = new CalculatorModel();
		this.calcGui = new CalculatorGui(this);
		this.calcGui.setVisible(true);
		this.calculator = new Calculator();
	}
	
	public void addListenerToModel(ICalculatorGui listener) {
		this.calcModel.addListener(listener);
	}
	
	public void calculate(final String pressContent) {
		final String calcResult = this.calculator.press(pressContent);
		if(this.isOperation(pressContent))
			this.calcModel.addDisplayAndSetInsertContent(calcResult, pressContent);
		if(this.isDigitOrDot(pressContent))
			this.calcModel.addDisplayAndAddInsertContent(calcResult, pressContent);
		if(this.isC(pressContent))
			this.calcModel.clearModel();
	}	
	
	private boolean isOperation(String button) {
		return button.matches("[=*/+-]");
	}
	
	private boolean isDigitOrDot(String button) {
		return button.matches("[.0-9]");
	}
	
	private boolean isC(String button) {
		return button.equalsIgnoreCase("c");
	}
}
