package edu.nwtc;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File(args[0]));
			int records = Integer.parseInt(args[1]);

			String ln = input.nextLine();
			while (!ln.trim().toLowerCase().startsWith("state")) {
				ln = input.nextLine();
			}
			
			for (int line = 0; line < records - 1; line++) {
				System.out.println(ln);
				ln = input.nextLine();
			}
			
			input.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
