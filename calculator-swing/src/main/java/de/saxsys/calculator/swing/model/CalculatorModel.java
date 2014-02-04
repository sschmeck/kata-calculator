package de.saxsys.calculator.swing.model;

import de.saxsys.calculator.swing.interfaces.ICalculatorGui;

/**
 * @author daniel.winter
 *
 */
public class CalculatorModel {

	private ICalculatorGui listener;
	
	private String insertContent = "";
	private String displayContent = "";
	
	public CalculatorModel() {		
	}
	
	public void addListener(ICalculatorGui listener) {
		this.listener = listener;
	}
	
	public void addDisplayWithSpaceAndSetInsertContent(final String calcResult, final String pressContent) {
		this.displayContent += " " +pressContent +" ";
		this.insertContent = calcResult;
		this.updateGui();
	}
	
	public void addDisplayWithoutSpaceAndSetInsertContent(final String calcResult, final String pressContent) {
		this.displayContent += pressContent;
		this.insertContent = calcResult;
		this.updateGui();
	}
		
	public void clearDisplayAndSetContent(final String calcResult) {
		this.displayContent = "";
		this.insertContent = calcResult;
		this.updateGui();
	}
	
	private void updateGui() {
		this.listener.updateDisplay(this.displayContent.trim());
		this.listener.updateInsertField(this.insertContent.trim());
	}
	
	public void clearModel() {
		this.insertContent = "";
		this.displayContent = "";
		this.updateGui();
	}
}