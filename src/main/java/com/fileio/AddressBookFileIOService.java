package com.fileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIOService {
    public static String ADDRESSBOOK_FILE_NAME = "addressBook-file.txt";

    public void writeData(List<AddressBookData> addressBooklist) {
        StringBuffer bookBuffer = new StringBuffer();
        addressBooklist.forEach(addressBookData -> {
            String addressBookDataString = addressBookData.toString().concat("\n");
            bookBuffer.append(addressBookDataString);
        });
        try {
            Files.write(Paths.get(ADDRESSBOOK_FILE_NAME), bookBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File("addressBook-file.txt").toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try { entries = Files.lines(new File(ADDRESSBOOK_FILE_NAME).toPath())
                .count();
        } catch (IOException e) { e.printStackTrace();
        }
        return entries;
    }

    public List<AddressBookData> readData() {
        List<AddressBookData> addressBook_List = new ArrayList<>();
        try {
            Files.lines(new File("addressBook-file.txt").toPath())
                    .map(line -> line.trim())
                    .forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressBook_List;
    }
}
