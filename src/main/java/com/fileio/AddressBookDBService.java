package com.fileio;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
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
}
