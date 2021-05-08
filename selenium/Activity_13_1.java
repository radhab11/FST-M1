package SeleniumActivities;


import java.io.File;
import java.io.FileReader;

import java.io.IOException;

import java.util.Iterator;

import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity_13_1 {

	public static void main(String[] args) throws IOException, CsvException {
		File file = new File("src/SeleniumActivities/sample.csv");
		boolean fStatus = file.createNewFile();
        if(fStatus) {
            System.out.println("File created successfully!");
        } else {
            System.out.println("File already exists at this path.");
        }
		CSVReader reader = new CSVReader(new FileReader("src/SeleniumActivities/sample.csv"));
		
		List<String[]> list = reader.readAll();
		System.out.println("Total Number of rows are: " +list.size());
		
		Iterator<String[]> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			String[] string = iterator.next();
			System.out.println("Values are: ");
			
			for(int i=0; i<string.length; i++) {
				System.out.println("  " + string[i]);	
			}
			System.out.println(" ");
		}
		reader.close();

	}

}
