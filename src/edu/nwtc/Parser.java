package edu.nwtc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File(args[0]));
			PrintStream output = new PrintStream(new File(args[1]));
			int records = Integer.parseInt(args[2]);

			String ln = input.nextLine();
			while (!ln.trim().toLowerCase().startsWith("state")) {
				ln = input.nextLine();
			}
			ln = input.nextLine();

			Map<String, State> states = new HashMap<String, State>();

			for (int line = 0; line < records - 1; line++) {
				String[] data = ln.split("\\t");
				String state = data[0].substring(0, 2);
				int population = Integer.parseInt(data[4].replace("\"", "").replace(",", ""));
				int relevant = Integer.parseInt(data[5].replace("\"", "").replace(",", ""));
				int estimate = Integer.parseInt(data[6].replace("\"", "").replace(",", ""));

				State st = new State(state);
				if (states.containsKey(state)) {
					st = states.get(state);
				}

				st.setPopulation(st.getPopulation() + population);
				st.setRelevant(st.getRelevant() + relevant);
				st.setEstimate(st.getEstimate() + estimate);

				states.put(state, st);

				ln = input.nextLine();
			}

			output.printf("%s\t%s\t%s\t%s\n", "State", "Total Child Population", "Number in Poverty",
					"Percentage of Population");

			for (State state : states.values()) {
				output.printf("%s\t%s\t%s\t%s\n", state.getState(), state.getRelevant(), state.getEstimate(),
						String.format("%,.2f%%", ((double) state.getEstimate() / (double) state.getRelevant()) * 100));
			}

			output.close();
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
