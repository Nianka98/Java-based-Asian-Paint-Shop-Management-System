package controller;

import java.sql.SQLException;
import java.util.List;
import facade.Stock;

public interface StockService {

    public void save(Stock stock) throws SQLException;

    public void update(Stock stock) throws SQLException;

    public void delete(int stockId) throws SQLException;

    public Stock getStockById(int stockId) throws SQLException;
    
    public Stock getProductById(String productId) throws SQLException;

    public List<Stock> loadAllStock() throws SQLException;

    public Stock searchByString(String searchString) throws SQLException;
}
