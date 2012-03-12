package de.saxsys.calculator.swing.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import de.saxsys.calculator.swing.controller.CalculatorController;
import de.saxsys.calculator.swing.interfaces.ICalculatorGui;

/**
 * @author daniel.winter
 *
 */
public class CalculatorGui extends JFrame implements ICalculatorGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4274210363764216222L;

	private final static String NULL_BUTTON_NAME = "0";
	private final static String PLUS_BUTTON_NAME = "+";
	private final static String MINUS_BUTTON_NAME = "-";
	private final static String MULT_BUTTON_NAME = "*";
	private final static String DIV_BUTTON_NAME = "/";
	private final static String DOT_BUTTON_NAME = ".";
	private final static String ENTER_BUTTON_NAME = "=";
	private final static String C_BUTTON_NAME = "c";
	
	private CalculatorController controller;
	
	private JTextField displayField;
	private JTextField insertField;
	
	public CalculatorGui(CalculatorController controller) {
		super("Schmecki - Rechner");
		this.controller = controller;
		this.controller.addListenerToModel(this);
		this.initGui();		
	}
	
	private void initGui() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		final JPanel display = this.initDisplay();
		final JPanel buttons = this.initButtons();
		
		this.add(display, BorderLayout.NORTH);
		this.add(buttons, BorderLayout.CENTER);
		
		this.pack();
		this.setResizable(false);
	}
	
	private JPanel initDisplay() {
		JPanel display = new JPanel(new BorderLayout());
		display.setBorder(new LineBorder(Color.BLACK));
		
		this.displayField = new JTextField();
		this.displayField.setName("displayField");
		this.displayField.setEditable(false);
		this.insertField = new JTextField();
		this.insertField.setName("insertField");
		this.insertField.setEditable(false);
		
		display.add(this.displayField, BorderLayout.NORTH);
		display.add(this.insertField, BorderLayout.SOUTH);
		
		return display;
	}
	
	private JPanel initButtons() {
		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5, 5, 5, 5);
				
		int buttonIndex = 1;
		for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
			for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
				this.addNumberButton(buttonIndex, rowIndex, columnIndex, buttons, gc);
				buttonIndex++;
			}
		}
			
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1;
		JButton nullButton = new JButton(CalculatorGui.NULL_BUTTON_NAME);
		nullButton.setName(CalculatorGui.NULL_BUTTON_NAME);
		nullButton.addActionListener(new ButtonActionListener(CalculatorGui.NULL_BUTTON_NAME));
		buttons.add(nullButton, gc);
		
		gc.gridx = 2;
		gc.gridy = 3;
		gc.gridwidth = 1;
		JButton dotButton = new JButton(CalculatorGui.DOT_BUTTON_NAME);
		dotButton.setName(CalculatorGui.DOT_BUTTON_NAME);
		dotButton.setEnabled(false);
		dotButton.addActionListener(new ButtonActionListener(CalculatorGui.DOT_BUTTON_NAME));
		buttons.add(dotButton, gc);
		
		gc.gridx = 3;
		gc.gridy = 0;
		JButton plusButton = new JButton(CalculatorGui.PLUS_BUTTON_NAME);
		plusButton.setName(CalculatorGui.PLUS_BUTTON_NAME);
		plusButton.addActionListener(new ButtonActionListener(CalculatorGui.PLUS_BUTTON_NAME));
		buttons.add(plusButton, gc);
		
		gc.gridx = 3;
		gc.gridy = 1;
		JButton minusButton = new JButton(CalculatorGui.MINUS_BUTTON_NAME);
		minusButton.setName(CalculatorGui.MINUS_BUTTON_NAME);
		minusButton.addActionListener(new ButtonActionListener(CalculatorGui.MINUS_BUTTON_NAME));
		buttons.add(minusButton, gc);
		
		gc.gridx = 3;
		gc.gridy = 2;
		JButton multButton = new JButton(CalculatorGui.MULT_BUTTON_NAME);
		multButton.setName(CalculatorGui.MULT_BUTTON_NAME);
		multButton.addActionListener(new ButtonActionListener(CalculatorGui.MULT_BUTTON_NAME));
		buttons.add(multButton, gc);
		
		gc.gridx = 3;
		gc.gridy = 3;
		JButton divButton = new JButton(CalculatorGui.DIV_BUTTON_NAME);
		divButton.setName(CalculatorGui.DIV_BUTTON_NAME);
		divButton.addActionListener(new ButtonActionListener(CalculatorGui.DIV_BUTTON_NAME));
		buttons.add(divButton, gc);
		
		gc.gridx = 4;
		gc.gridy = 0;
		gc.gridheight = 2;
		gc.weighty = 0.5;
		gc.fill = GridBagConstraints.BOTH;
		JButton cButton = new JButton(CalculatorGui.C_BUTTON_NAME);
		cButton.setName(CalculatorGui.C_BUTTON_NAME);
		cButton.addActionListener(new ButtonActionListener(CalculatorGui.C_BUTTON_NAME));
		buttons.add(cButton, gc);
		
		gc.gridx = 4;
		gc.gridy = 2;
		JButton enterButton = new JButton(CalculatorGui.ENTER_BUTTON_NAME);
		enterButton.setName(CalculatorGui.ENTER_BUTTON_NAME);
		enterButton.addActionListener(new ButtonActionListener(CalculatorGui.ENTER_BUTTON_NAME));
		buttons.add(enterButton, gc);
		
		return buttons;
	}
	
	private void addNumberButton(final int buttonName, final int row, final int column, 
			final JPanel panel, final GridBagConstraints gc) {
		final JButton button = new JButton(String.valueOf(buttonName));
		button.setName(String.valueOf(buttonName));
		button.addActionListener(new ButtonActionListener(button.getName()));
		
		gc.gridx = column;
		gc.gridy = row;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1;
		
		panel.add(button, gc);
	}

	@Override
	public void updateDisplay(final String content) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CalculatorGui.this.displayField.setText(content);
			}
		});
	}

	@Override
	public void updateInsertField(final String content) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CalculatorGui.this.insertField.setText(content);
			}
		});
	}
	
	private class ButtonActionListener implements ActionListener {		
		private final String pressContent;
		
		public ButtonActionListener(final String pressContent) {
			this.pressContent = pressContent;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread(new Runnable() {					
				@Override
				public void run() {
					CalculatorGui.this.controller.calculate(ButtonActionListener.this.pressContent);						
				}
			}).start();			
		}		
	}	
}
