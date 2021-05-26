package com.fileio;

public class AddressBookData {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String phoneNumber;
    public String zip;
    public String email;

    public AddressBookData(String firstName, String lastName, String address, String city,
                           String state, String phoneNumber, String zip, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBookData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", zip=" + zip +
                ", email='" + email + '\'' +
                '}';
    }
}
