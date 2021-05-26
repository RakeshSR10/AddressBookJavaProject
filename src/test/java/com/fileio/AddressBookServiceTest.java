package com.fileio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.fileio.AddressBookService.IOService.DB_IO;
import static com.fileio.AddressBookService.IOService.FILE_IO;

public class AddressBookServiceTest {
    //UC 13 - Read and Write AddressBook Data and Also Check Number of Entries
    @Test
    public void given2AddressBookWhenWrittenToFileShouldMatchAddressBookEntries() {
        AddressBookData[] arrayOfAddressBook = {
                new AddressBookData("Rakesh","SR","Siddanuru","Davanagere","Karnataka","9874563210","123456","rakesh@gmail.com"),
                new AddressBookData("Vishnu","Dada","Mysore-Area","Mysore","Karnataka","9856471230","221133","vishnu@gmail.com")
        };
        AddressBookService addressBookService;
        addressBookService = new AddressBookService(Arrays.asList(arrayOfAddressBook));
        addressBookService.writeAddressBookData(FILE_IO);
        addressBookService.printData(FILE_IO);
        long entries = addressBookService.countEntries(FILE_IO);
        System.out.println("Total Number of Entries : "+entries);
        Assertions.assertEquals(2,entries);
    }
    //UC 16 - Refactor and Retrieve data of addressbook DB table
    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchContactCount() {
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(DB_IO);
        Assertions.assertEquals(2,addressBookData.size());
    }
    //UC 17 - Update lastName from addressbook table
    @Test
    public void giveNewLastNameForEmployee_WhenUpdated_ShouldSyncWithDB() {
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(DB_IO);
        addressBookService.updateContactLastName("Rakesh", "SR");
        boolean result = addressBookService.checkAddressBookInSyncWithDB("Rakesh");
        Assertions.assertTrue(result);
    }
}
