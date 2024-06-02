
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import facade.Customer;
import util.ConnectDatabase;

public class CustomerServiceImplement implements CustomerService {

    @Override
    public void save(Customer customer) throws SQLException {
        PreparedStatement saveStatement = ConnectDatabase.getConnection()
                .prepareStatement("INSERT INTO customer (firstname,lastname,email,status) VALUES(?,?,?,?)");
        saveStatement.setString(1, customer.getFirstName());
        saveStatement.setString(2, customer.getLastName());
        saveStatement.setString(3, customer.getEmail());
        saveStatement.setInt(4, customer.getStatus());

        saveStatement.execute();
        saveStatement.close();
    }

    @Override
    public void update(Customer customer) throws SQLException {
        PreparedStatement updateStatement = ConnectDatabase.getConnection()
                .prepareStatement("UPDATE customer SET firstname=?, lastname=?, email=?, status=? WHERE customerid=?");
        updateStatement.setString(1, customer.getFirstName());
        updateStatement.setString(2, customer.getLastName());
        updateStatement.setString(3, customer.getEmail());
        updateStatement.setInt(4, customer.getStatus());
        updateStatement.setInt(5, customer.getCustomerId());
        updateStatement.execute();
        updateStatement.close();
    }

    @Override
    public void delete(int customerId) throws SQLException {
        PreparedStatement deleteStatement = ConnectDatabase.getConnection()
                .prepareStatement("DELETE FROM customer WHWRE customerid=?");
        deleteStatement.setInt(1, customerId);
        deleteStatement.executeUpdate();
        deleteStatement.close();
    }

    @Override
    public Customer getCustomerById(int customerId) throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT customerid,firstname,lastname,email,status FROM customer WHERE customerid=?");
        searchByStatement.setInt(1, customerId);

        ResultSet rs = searchByStatement.executeQuery();
        Customer customer = new Customer();

        while (rs.next()) {
            customer.setCustomerId(rs.getInt("customerid"));
            customer.setFirstName(rs.getString("firstname"));
            customer.setLastName(rs.getString("lastname"));
            customer.setEmail(rs.getString("email"));
            customer.setStatus(rs.getInt("status"));
        }

        searchByStatement.close();
        
        return customer;
    }

    @Override
    public List<Customer> loadAllCustomers() throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT customerid,firstname,lastname,email,status FROM customer");

        ResultSet resultSet = searchByStatement.executeQuery();

        List<Customer> customerList = new ArrayList();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getInt("customerid"));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setLastName(resultSet.getString("lastname"));
            customer.setEmail(resultSet.getString("email"));
            customer.setStatus(resultSet.getInt("status"));

            customerList.add(customer);
        }

        searchByStatement.close();

        return customerList;
    }

    @Override
    public Customer searchByString(String searchString) throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT customerid,firstname,lastname,email,status FROM customer WHERE firstname=?");
        searchByStatement.setString(1, searchString);

        ResultSet rs = searchByStatement.executeQuery();
        Customer customer = new Customer();

        while (rs.next()) {
            customer.setCustomerId(rs.getInt("customerid"));
            customer.setFirstName(rs.getString("firstname"));
            customer.setLastName(rs.getString("lastname"));
            customer.setEmail(rs.getString("email"));
            customer.setStatus(rs.getInt("status"));
        }

        searchByStatement.close();

        return customer;
    }

}
