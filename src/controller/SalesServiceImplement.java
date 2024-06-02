package controller;

import facade.Customer;
import facade.InvoiceFacade;
import facade.Stock;
import facade.ViewSales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectDatabase;

public class SalesServiceImplement implements SalesService {

    @Override
    public void createSale(List<InvoiceFacade> invoiceFacadeList, String invoiceId, int customerId, double total, String proId) throws SQLException {

        PreparedStatement saveStatement = ConnectDatabase.getConnection()
                .prepareStatement("INSERT INTO sales (invoice_id,customer_id,product_id,subtotal) VALUES(?,?,?,?)");
        saveStatement.setString(1, invoiceId);
        saveStatement.setInt(2, customerId);
        saveStatement.setString(3, proId);
        saveStatement.setDouble(4, total);

        saveStatement.execute();
        saveStatement.close();

        for (InvoiceFacade invoice : invoiceFacadeList) {
            PreparedStatement saveStatementTwo = ConnectDatabase.getConnection()
                    .prepareStatement("INSERT INTO sales_items (invoice_id,qty,total) VALUES(?,?,?)");
            saveStatementTwo.setString(1, invoiceId);
            saveStatementTwo.setDouble(2, invoice.getQty());
            saveStatementTwo.setDouble(3, invoice.getTotalPrice());
            saveStatementTwo.execute();
        }

    }

    @Override
    public List<ViewSales> getSalesRecords() throws SQLException {
        PreparedStatement searchStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT invoice_id,customer_id,product_id,subtotal FROM sales");

        ResultSet rs = searchStatement.executeQuery();

        List<ViewSales> salesList = new ArrayList();
        List<Integer> cusIds = new ArrayList();
        List<String> proIds = new ArrayList();

        while (rs.next()) {
            cusIds.add(rs.getInt("customer_id"));
            proIds.add(rs.getString("product_id"));

            ViewSales viewSales = new ViewSales();
            viewSales.setTotal(rs.getDouble("subtotal"));

            salesList.add(viewSales);
        }

        searchStatement.close();

        for (int i = 0; i < salesList.size(); i++) {
            CustomerService customerService = new CustomerServiceImplement();
            Customer customer = customerService.getCustomerById(cusIds.get(i));
            salesList.get(i).setCustomerName(customer.getFirstName() + " " + customer.getLastName());
        }

        //
//        for (int i = 0; i < salesList.size(); i++) {
//            StockService stockService = new StockServiceImplement();
//            if (proIds.get(i) != null) {
//                Stock stock = stockService.getProductById(proIds.get(i));
//                salesList.get(i).setProductName(stock.getProductName());
//            }
//        }

        return salesList;
    }
}
