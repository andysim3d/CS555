package edu.stevens.cs555.dispatch;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.stevens.cs555.factory.Input2Node;

public class GedcomDispatch {

	private Input2Node node;
	
	public void cli() {

		// Main command-line interface loop
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (true) {
				System.out.print("<GEDCOM Analyzer>:");
				String line = in.readLine();
				String[] inputs = line.split("\\s+");
				if (inputs.length > 0) {
					String cmd = inputs[0];
					if (cmd.length() == 0)
						;
					else if ("read".equals(cmd)){
						read(inputs[1]);
					}else if ("help".equals(cmd)){
						help(inputs);
					}else if ("quit".equals(cmd)){
						System.out.println("Exit GEDCOM Analyzer!");
						return;
					}else
						System.out.println("Bad input.  Type \"help\" for more information.");
				}
			}
		} catch (EOFException e) {
		} catch (IOException e) {
			System.out.println(e);
			System.exit(-1);
		}

	}

	public void help(String[] inputs) {
		if (inputs.length == 1) {
			System.out.println("Commands are:");
			// Read GEDCOM file
			System.out.println("  read file: read a GEDCOM file");
			// Exit
			System.out.println("  quit: exit the GEDCOM analyzer");
		}
	}

	public void read(String fileName) {
		try {
			System.out.println("Reading GEDCOM file");
			node = Input2Node.getInstance(fileName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
