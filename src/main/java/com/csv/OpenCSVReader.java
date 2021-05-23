package com.csv;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
    private static final String ADDRESS_BOOK_FILE = "C:\\Users\\User\\IdeaProjects\\AddressBookJavaProject\\src\\main\\resources\\addressBookData.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(ADDRESS_BOOK_FILE));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            //reading records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                System.out.println("FirstName = "+nextRecord[0]);
                System.out.println("LastName = "+nextRecord[1]);
                System.out.println("Address = "+nextRecord[2]);
                System.out.println("City = "+nextRecord[3]);
                System.out.println("State = "+nextRecord[4]);
                System.out.println("Phone-Number = "+nextRecord[5]);
                System.out.println("Zip = "+nextRecord[6]);
                System.out.println("Email = "+nextRecord[7]);
                System.out.println("=========================");
            }
            //Reading all Records at once into a List<String[]>
            List<String[]> records = csvReader.readAll();
            for(String[] record: records){
                System.out.println("FirstName = "+nextRecord[0]);
                System.out.println("LastName = "+nextRecord[1]);
                System.out.println("Address = "+nextRecord[2]);
                System.out.println("City = "+nextRecord[3]);
                System.out.println("State = "+nextRecord[4]);
                System.out.println("Phone-Number = "+nextRecord[5]);
                System.out.println("Zip = "+nextRecord[6]);
                System.out.println("Email = "+nextRecord[7]);
                System.out.println("=========================");
            }
        }
    }
}
