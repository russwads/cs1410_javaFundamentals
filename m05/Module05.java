package m05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module05 {

	public static void main(String[] args) {
		List<String> content = new ArrayList<String>();
		List<String> content2 = new ArrayList<String>();
		// Initializing reader and writer of files
		try (Scanner s1= new Scanner(Module05.class.getResourceAsStream("/m05/Resources/Quote.txt"));
				PrintWriter pw = new PrintWriter("Quote2.txt")) {
			while (s1.hasNextLine()) {
				// Adding content to list
				content.add(s1.nextLine());
			}
			// Printing content of list on screen
			content.forEach(x -> System.out.println(x));
			System.out.println();
			
			// Changes casing for each line
			for (int i = 0; i < content.size(); i++) {
				int j = i + 1;
				String leading = String.format("%02d ", j);
				if (j % 2 == 0) {
					content2.add(leading + content.get(i).toLowerCase());
				}
				else {
					content2.add(leading + content.get(i).toUpperCase());
				}
			}
			// Printing reformed content of list on screen
			content2.forEach(x -> System.out.println(x));
			
			for (int i = 0; i < content2.size(); i++) {
				pw.print(content2.get(i));
				pw.println();
				pw.println();
			}
		} 
		catch(IOException e) {
			System.err.println("File I/O has reached an error. Please try operation again.");
		} 
		catch(NullPointerException e) {
			System.err.println("Error in processing file. Please try again.");
		}
	}

}
