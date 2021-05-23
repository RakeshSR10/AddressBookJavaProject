package com.gridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    Scanner scanner = new Scanner(System.in);
    ArrayList<AddressBook> list = new ArrayList<>();
    //UC1 - creating contacts
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public AddressBook(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public AddressBook() {

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {

        return "Details of: " + firstName+"\n"
                + "First Name: "+ firstName +"\n"
                + "Last Name: " + lastName+"\n"
                + "Address: " + address + "\n"
                + "City: " + city + "\n"
                + "State: " + state + "\n"
                + "Zip: " + zip + "\n"
                + "Phone Number: " + phone + "\n"
                + "Email: " + email;
    }

    //UC2 - Add Contact Details of Person
    public void addDetails() {
        System.out.print("Enter First Name ");
        firstName = scanner.next();
        System.out.print("Enter Last Name ");
        lastName = scanner.next();
        System.out.print("Enter Address ");
        address = scanner.next();
        System.out.print("Enter City ");
        city = scanner.next();
        System.out.print("Enter State ");
        state = scanner.next();
        System.out.print("Enter Zip ");
        zip = scanner.next();
        System.out.print("Enter Phone Number ");
        phone = scanner.next();
        System.out.print("Enter Email ");
        email = scanner.next();
        list.add(new AddressBook(firstName, lastName, address, city, state, zip, phone, email));
    }
    //UC3 - Edit Contact Details of Person
    public void editDetails() {
        System.out.print("Enter First Name ");
        firstName = scanner.next();
        System.out.print("Enter Last Name ");
        lastName = scanner.next();
        System.out.print("Enter Address ");
        address = scanner.next();
        System.out.print("Enter City ");
        city = scanner.next();
        System.out.print("Enter State ");
        state = scanner.next();
        System.out.print("Enter Zip ");
        zip = scanner.next();
        System.out.print("Enter Phone Number ");
        phone = scanner.next();
        System.out.print("Enter Email ");
        email = scanner.next();
    }
    //UC4 - Delete Contact Details of Person
    private void deleteDetails() {
        System.out.println("Enter Name to be deleted.:");
        String removeName = scanner.next();
        if (removeName.equalsIgnoreCase(firstName)) {
            list.removeAll(list);
            System.out.println("Successfully Deleted...!");
        } else {
            System.out.println("Invalid Contact.....! Re-enter Name");
        }
    }
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addDetails();
        addressBook.editDetails();
        addressBook.deleteDetails();
    }
}
