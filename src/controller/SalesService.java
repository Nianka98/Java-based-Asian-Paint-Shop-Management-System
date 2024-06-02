package controller;

import facade.InvoiceFacade;
import facade.ViewSales;
import java.sql.SQLException;
import java.util.List;

public interface SalesService {

    public void createSale(List<InvoiceFacade> invoiceFacadeList, String invoiceId, int customerId, double total,String proId) throws SQLException;

    public List<ViewSales> getSalesRecords() throws SQLException;

}
