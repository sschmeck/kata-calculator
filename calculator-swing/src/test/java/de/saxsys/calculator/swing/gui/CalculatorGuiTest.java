package de.saxsys.calculator.swing.gui;


import org.fest.swing.fixture.FrameFixture;
import org.junit.Test;

import de.saxsys.calculator.swing.controller.CalculatorController;

/**
 * @author daniel.winter
 * 
 */
public class CalculatorGuiTest {

	private FrameFixture frame;
	
	@Test
	public void pressNumberAndCheckDisplay() {
		final CalculatorController controller = new CalculatorController();
		controller.initModel();
		this.frame = new FrameFixture(new CalculatorGui(controller));
		frame.show();
		
		for (int buttonIndex = 0; buttonIndex < 10; buttonIndex++) {
			frame.button(String.valueOf(buttonIndex)).click();
			frame.textBox("insertField").requireText(String.valueOf(buttonIndex));
			frame.textBox("displayField").requireText(String.valueOf(buttonIndex));		
			
			frame.button("c").click();
			frame.textBox("insertField").requireText("");
			frame.textBox("displayField").requireText("");	
		}
		
		for (int buttonIndex = 1; buttonIndex < 10; buttonIndex++) {
			for (int secondButtonIndex = 1; secondButtonIndex < 2; secondButtonIndex++) {
				frame.button(String.valueOf(buttonIndex)).click();
				frame.button(String.valueOf(secondButtonIndex)).click();
				frame.textBox("insertField").requireText(String.valueOf(buttonIndex) +String.valueOf(secondButtonIndex));
				frame.textBox("displayField").requireText(String.valueOf(buttonIndex +String.valueOf(secondButtonIndex)));		
				
				frame.button("c").click();
				frame.textBox("insertField").requireText("");
				frame.textBox("displayField").requireText("");	
			}			
		}
		
		frame.button("0").click();
		frame.textBox("insertField").requireText("0");
		frame.textBox("displayField").requireText("0");
		
		frame.button("0").click();
		frame.textBox("insertField").requireText("0");
		frame.textBox("displayField").requireText("00");
		
		frame.button("1").click();
		frame.textBox("insertField").requireText("1");
		frame.textBox("displayField").requireText("001");
		frame.cleanUp();
	}
	
	@Test
	public void add() {
		final CalculatorController controller = new CalculatorController();
		controller.initModel();
		this.frame = new FrameFixture(new CalculatorGui(controller));
		frame.show();
		
		frame.button("0").click();
		frame.button("+").click();
		frame.button("1").click();
		
		frame.textBox("insertField").requireText("1");
		frame.textBox("displayField").requireText("0 + 1");
		
		frame.button("=").click();
		
		frame.textBox("insertField").requireText("1");
		frame.textBox("displayField").requireText("");
		
		frame.cleanUp();
	}

	@Test
	public void sub() {
		final CalculatorController controller = new CalculatorController();
		controller.initModel();
		this.frame = new FrameFixture(new CalculatorGui(controller));
		frame.show();
		
		frame.button("0").click();
		frame.button("-").click();
		frame.button("1").click();
		
		frame.textBox("insertField").requireText("1");
		frame.textBox("displayField").requireText("0 - 1");
		
		frame.button("=").click();
		
		frame.textBox("insertField").requireText("-1");
		frame.textBox("displayField").requireText("");
		
		frame.cleanUp();
	}
	
	@Test
	public void mult() {
		final CalculatorController controller = new CalculatorController();
		controller.initModel();
		this.frame = new FrameFixture(new CalculatorGui(controller));
		frame.show();
		
		frame.button("2").click();
		frame.button("*").click();
		frame.button("5").click();
		
		frame.textBox("insertField").requireText("5");
		frame.textBox("displayField").requireText("2 * 5");
		
		frame.button("=").click();
		
		frame.textBox("insertField").requireText("10");
		frame.textBox("displayField").requireText("");
		
		frame.cleanUp();
	}
		
	@Test
	public void div() {
		final CalculatorController controller = new CalculatorController();
		controller.initModel();
		this.frame = new FrameFixture(new CalculatorGui(controller));
		frame.show();
		
		frame.button("1").click();
		frame.button("0").click();
		frame.button("/").click();
		frame.button("5").click();
		
		frame.textBox("insertField").requireText("5");
		frame.textBox("displayField").requireText("10 / 5");
		
		frame.button("=").click();
		
		frame.textBox("insertField").requireText("2");
		frame.textBox("displayField").requireText("");
		
		frame.cleanUp();
	}
}
