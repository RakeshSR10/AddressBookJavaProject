package com.csv;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class AddressBookGsonTester {
    private static final String ADDRESS_BOOK_FILE_PATH = "C:\\Users\\User\\IdeaProjects\\AddressBookJavaProject\\src\\main\\resources\\addressBookData.csv";
    private static final String ADDRESS_BOOK_JSON_PATH = "C:\\Users\\User\\IdeaProjects\\AddressBookJavaProject\\src\\main\\resources\\addressBookData.json";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(ADDRESS_BOOK_FILE_PATH));
            CsvToBeanBuilder<ContactCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(ContactCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<ContactCSV> csvToBean = csvToBeanBuilder.build();
            List<ContactCSV> contactCSV = csvToBean.parse();

            Gson gson = new Gson();
            String json = gson.toJson(contactCSV);
            FileWriter writer = new FileWriter(ADDRESS_BOOK_JSON_PATH);
            writer.write(json);
            writer.close();

            BufferedReader br = new BufferedReader(new FileReader(ADDRESS_BOOK_JSON_PATH));
            ContactCSV[] usrObj = gson.fromJson(br, ContactCSV[].class);
            List<ContactCSV> csvUserList = Arrays.asList(usrObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
