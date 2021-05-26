package com.fileio;

import java.util.*;

public class AddressBookService {
    //UC 13 -
    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO
    }
    private List<AddressBookData> addressBooklist;
    private static AddressBookDBService addressBookDBService;//Singleton
    public AddressBookService() {}
    public AddressBookService(List<AddressBookData> addressBooklist) {
        this.addressBooklist = addressBooklist;
    }

    public static void main(String[] args) {
        ArrayList<AddressBookData> addressBooklist = new ArrayList<>();
        AddressBookService addressBookService = new AddressBookService(addressBooklist);
        Scanner consoleInputReader = new Scanner(System.in);
        addressBookService.readAddressBookData(consoleInputReader);
        addressBookService.writeAddressBookData(IOService.CONSOLE_IO);
    }

    private void readAddressBookData(Scanner consoleInputReader) {
        System.out.println("Enter First Name:");
        String firstName = consoleInputReader.next();
        System.out.println("Enter Last Name:");
        String lastName = consoleInputReader.next();
        System.out.println("Enter Address:");
        String address = consoleInputReader.next();
        System.out.println("Enter City Name:");
        String city = consoleInputReader.next();
        System.out.println("Enter State Name:");
        String state = consoleInputReader.next();
        System.out.println("Enter Mobile-Number:");
        String phoneNumber = consoleInputReader.next();
        System.out.println("Enter Zip:");
        String zip = consoleInputReader.next();
        System.out.println("Enter Email:");
        String email = consoleInputReader.next();
        addressBooklist.add(new AddressBookData(firstName,lastName,address,city,state,phoneNumber,zip,email));
    }
    //UC 13 - Write AddressBookData
    public void writeAddressBookData(IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("\n Writting AddressBook Roaster to Console\n");
        } else if(ioService.equals(IOService.FILE_IO)) {
            new AddressBookFileIOService().writeData(addressBooklist);
        }
    }
    //UC 16 -Retrieve Address Book data from DB
    public List<AddressBookData> readAddressBookData(IOService ioService){
        if(ioService.equals(IOService.DB_IO))
            this.addressBooklist = new AddressBookDBService().readData();
        return this.addressBooklist;
    }
    //Uc 17 - Update Contact
    public void updateContactLastName(String firstName, String lastName) {
        String result = addressBookDBService.updateContactData(firstName,lastName);
        if (result == "0") return;
        AddressBookData addressBookData = this.getAddressBookData(firstName);
        if (addressBookData != null) addressBookData.lastName = lastName;
    }

    public boolean checkAddressBookInSyncWithDB(String firstName) {
        List<AddressBookData> addressBooklist = addressBookDBService.getAddressBookData(firstName);
        return addressBooklist.get(0).equals(getAddressBookData(firstName));
    }

    private AddressBookData getAddressBookData(String firstName) {
        return this.addressBooklist.stream()
                .filter(addressBookDataItem -> addressBookDataItem.firstName.equals(firstName))
                .findFirst()
                .orElse(null);
    }
    //UC 13 - Read AddressBookData
    public long readAddressBookData1(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            this.addressBooklist = new AddressBookFileIOService().readData();
        return addressBooklist.size();
    }

    public void printData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            new AddressBookFileIOService().printData();
    }
    //UC4 -count data
    public long countEntries(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            return new AddressBookFileIOService().countEntries();
        return 0;
    }
}
