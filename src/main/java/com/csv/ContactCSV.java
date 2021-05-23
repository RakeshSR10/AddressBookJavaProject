package com.csv;
import com.opencsv.bean.CsvBindByName;
public class ContactCSV {
    @CsvBindByName
    private String firstName;

    @CsvBindByName
    private String lastName;

    @CsvBindByName
    private String address;

    @CsvBindByName
    private String city;

    @CsvBindByName
    private String state;

    @CsvBindByName(column = "phone")
    private String phoneNumber;

    @CsvBindByName(column = "zip")
    private String zip;

    @CsvBindByName(column = "email", required = true)
    private String email;

    public ContactCSV(String firstName, String lastName, String address, String city,
                      String state, String phoneNumber, String zip, String email) {
    }


    @Override
    public String toString() {
        return "ContactCSV{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", zip='" + zip + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getZip() {
        return zip;
    }

    public String getEmail() {
        return email;
    }

}
