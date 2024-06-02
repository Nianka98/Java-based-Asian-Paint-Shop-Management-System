/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import facade.Customer;

public interface CustomerService {

    public void save(Customer customer) throws SQLException;
    
    public void update(Customer customer) throws SQLException;

    public void delete(int customerId) throws SQLException;

    public Customer getCustomerById(int customerId) throws SQLException;
    
    public List<Customer> loadAllCustomers() throws SQLException;

    public Customer searchByString(String searchString) throws SQLException;
    
}
