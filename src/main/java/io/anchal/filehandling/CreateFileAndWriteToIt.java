package io.anchal.filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileAndWriteToIt {

	public static void main(String args[]) throws IOException {

		//File file = new File("TestFile");
		String str= "This should be written to file";
String fileName="D:/sample.txt";
		/*if (!file.exists()) {
			file.createNewFile();
			System.out.println("File is created");
		}*/

		FileWriter writer = new FileWriter(fileName,true);
		//writer.write("Test data");
		writer.append("\nthis is to append");
		writer.close();

		//createFileUsingFileOutputStreamClass();
		appendStrToFile(fileName, str);

	}

	/*private static void createFileUsingFileOutputStreamClass() throws IOException {
		String data = "Test data";
		FileOutputStream out = new FileOutputStream("testFile2.txt");
		out.write(data.getBytes());
		out.close();
	}
	*/

	public static void appendStrToFile(String fileName, String str) {
		try {

// Open given file in append mode. 
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
			out.write(str);
			out.close();
		} catch (IOException e) {
			System.out.println("exception occured" + e);
		}
	}
}
