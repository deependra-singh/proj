package org.assignment.six.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Deependra Singh
 * @purpose Read input data from keyboard and write it into file1. Copy contents
 *          to file2.
 */

public class CopyToFile {
	public static void main(String[] args) {

		String text, fileReadText;
		BufferedReader bufferedReader;

		try {
			// open buffered reader
			bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));

			// enter text to be written in file1
			System.out.println("Enter Text:");
			text = bufferedReader.readLine();

			// write to the file using print writer
			PrintWriter pw = new PrintWriter(new FileWriter("D:/file1.txt"),
					true);
			pw.write(text);
			pw.close();

			// read from file1
			bufferedReader = new BufferedReader(new FileReader("D:/file1.txt"));

			// write to file2
			PrintWriter pw2 = new PrintWriter(new FileWriter("D:/file2.txt"),
					true);
			while ((fileReadText = bufferedReader.readLine()) != null) {
				pw2.write(fileReadText);

			}

			pw2.close();

		}

		catch (IOException e) {
		}
	}

}
