package com.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class AddressBookOpenCSVReadAndParseToBean {
    private static final String ADDRESS_BOOK_FILE = "C:\\Users\\User\\IdeaProjects\\AddressBookJavaProject\\src\\main\\resources\\addressBookData.csv";

    public static void main(String[] args) throws IOException {
        try(Reader reader = Files.newBufferedReader(Paths.get(ADDRESS_BOOK_FILE));) {
            CsvToBean<ContactCSV> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ContactCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<ContactCSV> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                ContactCSV csvUser = csvUserIterator.next();
                System.out.println("FirstName = "+csvUser.getFirstName());
                System.out.println("LastName = "+csvUser.getLastName());
                System.out.println("Address = "+csvUser.getAddress());
                System.out.println("City = "+csvUser.getCity());
                System.out.println("State = "+csvUser.getState());
                System.out.println("Phone-Number = "+csvUser.getPhoneNumber());
                System.out.println("Zip = "+csvUser.getZip());
                System.out.println("Email = "+csvUser.getEmail());
                System.out.println(".....................................");
            }
            //Read all CSV contents into memory (Not suitable for large CSV files)
            List<ContactCSV> csvUsers = csvToBean.parse();

            for(ContactCSV csvUser: csvUsers){
                System.out.println("FirstName = "+csvUser.getFirstName());
                System.out.println("LastName = "+csvUser.getLastName());
                System.out.println("Address = "+csvUser.getAddress());
                System.out.println("City = "+csvUser.getCity());
                System.out.println("State = "+csvUser.getState());
                System.out.println("Phone-Number = "+csvUser.getPhoneNumber());
                System.out.println("Zip = "+csvUser.getZip());
                System.out.println("Email = "+csvUser.getEmail());
                System.out.println(".....................................");
            }
        }
    }
}
