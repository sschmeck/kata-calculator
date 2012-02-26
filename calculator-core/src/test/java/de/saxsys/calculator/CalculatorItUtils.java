package de.saxsys.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorItUtils {

	private static final String CALCULATOR_JAR = "calculator-core-1.0-SNAPSHOT.jar";
	
	public static Process runApplicationWithArgument(String arg) throws IOException,
			InterruptedException {
		Process process = new ProcessBuilder("java", "-jar", "target/"
				+ CALCULATOR_JAR, arg).start();
		process.waitFor();
		return process;
	}

	public static String getOutput(Process application) throws IOException {
		String currentLine;
		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				application.getInputStream()));
		while (null != (currentLine = reader.readLine())) {
			output.append(currentLine).append("\n");
		}
		return output.toString().trim();
	}
}
