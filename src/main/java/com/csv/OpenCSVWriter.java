package com.csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    private static String ADDRESS_BOOK_CSV_FILE = "C:\\Users\\User\\IdeaProjects\\AddressBookJavaProject\\src\\main\\resources\\addressBookData.csv";

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        try(
                Writer writer = Files.newBufferedWriter(Paths.get(ADDRESS_BOOK_CSV_FILE));
        ) {
            StatefulBeanToCsv<ContactCSV> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                                    .build();
            List<ContactCSV> contactCSVList = new ArrayList<>();
            contactCSVList.add(new ContactCSV("Rakesh","SR","Siddanuru","Davanagere",
                                         "Karnataka","9874563210","123123","rakesh@gmail.com"));
            contactCSVList.add(new ContactCSV("Vishnu","Dada","Mysore-Street","Mysore",
                                         "Karnataka","7891236540","557510","vishnu@gmail.com"));
            beanToCsv.write(contactCSVList);
        }
    }
}
