package com.fileio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
    private PreparedStatement addressBookDataStatement;
    private static AddressBookDBService addressBookDBService;//Singleton for generating only one instance
    //Constructor
    public AddressBookDBService() {

    }
    //Creating only one Instance
    public static AddressBookDBService getInstance() {
        if (addressBookDBService == null)
            addressBookDBService = new AddressBookDBService();
        return addressBookDBService;
    }

    //Establish connection
    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service?useSSL=false";
        String userName = "root";
        String password = "1234";
        Connection connection;
        System.out.println("Connecting to database...!!!!    "+jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is Successfull.....!   "+connection);
        return connection;
    }
    //UC2 Retrieve Data using Query
    public List<AddressBookData> readData(){
        String sql = "SELECT * FROM addressbook";
        List<AddressBookData> employeePayrollList = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String phoneNumber = resultSet.getString("phoneNumber");
                String zip = resultSet.getString("zip");
                String email = resultSet.getString("email");
                employeePayrollList.add(new AddressBookData(firstName,lastName,address,city,state,phoneNumber,zip,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
    //UC 17 - Update Contact
    public List<AddressBookData> getAddressBookData(String firstName) {
        List<AddressBookData> addressBookList = null;
        if (this.addressBookDataStatement == null)
            this.prepareStatementForAddressBookData();
        try {
            addressBookDataStatement.setString(1,firstName);
            ResultSet resultSet = addressBookDataStatement.executeQuery();
            addressBookList = this.getAddressBookData(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    private List<AddressBookData> getAddressBookData(ResultSet resultSet) {
        List<AddressBookData> addressBookList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String phoneNumber = resultSet.getString("phoneNumber");
                String zip = resultSet.getString("zip");
                String email = resultSet.getString("email");
                addressBookList.add(new AddressBookData(firstName,lastName,address,city,state,phoneNumber,zip,email));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    private void prepareStatementForAddressBookData() {
        try {
            Connection connection = this.getConnection();
            String sql = "SELECT * FROM addressbook WHERE firstName = ?";
            addressBookDataStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String updateContactData(String firstName, String lastName) {
        return this.updateAddressBookDataUsingStatement(firstName, lastName);
    }

    private String updateAddressBookDataUsingStatement(String firstName, String lastName) {
        String sql = String.format("update addressbook set lastName = '%s' where firstName = '%s';", lastName, firstName);
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            return String.valueOf(statement.executeUpdate(sql));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
