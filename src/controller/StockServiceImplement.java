package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import facade.Stock;
import util.ConnectDatabase;

public class StockServiceImplement implements StockService {

    @Override
    public void save(Stock stock) throws SQLException {
        PreparedStatement saveStatement = ConnectDatabase.getConnection()
                .prepareStatement("INSERT INTO stock (product_id,productname,qty,price,liter) VALUES(?,?,?,?,?)");
        saveStatement.setString(1, stock.getProductId());
        saveStatement.setString(2, stock.getProductName());
        saveStatement.setDouble(3, stock.getQuantity());
        saveStatement.setDouble(4, stock.getPrice());
        saveStatement.setDouble(5, stock.getLiter());

        saveStatement.execute();
        saveStatement.close();
    }

    @Override
    public void update(Stock stock) throws SQLException {
        PreparedStatement saveStatement = ConnectDatabase.getConnection()
                .prepareStatement("UPDATE stock SET product_id=?, productname=?, qty=?, price=?,liter=? WHERE stockid=?");
        saveStatement.setString(1, stock.getProductId());
        saveStatement.setString(2, stock.getProductName());
        saveStatement.setDouble(3, stock.getQuantity());
        saveStatement.setDouble(4, stock.getPrice());
        saveStatement.setDouble(5, stock.getLiter());
        saveStatement.setInt(6, stock.getStockId());

        saveStatement.execute();
        saveStatement.close();
    }

    @Override
    public void delete(int stockId) throws SQLException {
        PreparedStatement deleteStatement = ConnectDatabase.getConnection()
                .prepareStatement("DELETE FROM stock WHWRE stockid=?");
        deleteStatement.setInt(1, stockId);
        deleteStatement.executeUpdate();
        deleteStatement.close();
    }

    @Override
    public Stock getStockById(int stockId) throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT stockid,product_id,productname,qty,price,liter FROM stock WHERE stockid=?");
        searchByStatement.setInt(1, stockId);

        ResultSet rs = searchByStatement.executeQuery();
        Stock stock = new Stock();

        while (rs.next()) {
            stock.setStockId(rs.getInt("stockid"));
            stock.setProductId(rs.getString("product_id"));
            stock.setProductName(rs.getString("productname"));
            stock.setQuantity(rs.getDouble("qty"));
            stock.setPrice(rs.getDouble("price"));
            stock.setLiter(rs.getDouble("liter"));
        }

        searchByStatement.close();

        return stock;
    }

    @Override
    public List<Stock> loadAllStock() throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT stockid,product_id,productname,qty,price,liter FROM stock");

        ResultSet resultSet = searchByStatement.executeQuery();

        List<Stock> stockList = new ArrayList();

        while (resultSet.next()) {
            Stock stock = new Stock();
            stock.setStockId(resultSet.getInt("stockid"));
            stock.setProductId(resultSet.getString("product_id"));
            stock.setProductName(resultSet.getString("productname"));
            stock.setQuantity(resultSet.getDouble("qty"));
            stock.setPrice(resultSet.getDouble("price"));
            stock.setLiter(resultSet.getDouble("liter"));

            stockList.add(stock);
        }

        searchByStatement.close();

        return stockList;
    }

    @Override
    public Stock searchByString(String searchString) throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT stockid,product_id,productname,qty,price,liter FROM stock WHERE productname=?");
        searchByStatement.setString(1, searchString);

        ResultSet resultSet = searchByStatement.executeQuery();
        Stock stock = new Stock();

        while (resultSet.next()) {
            stock.setStockId(resultSet.getInt("stockid"));
            stock.setProductId(resultSet.getString("product_id"));
            stock.setProductName(resultSet.getString("productname"));
            stock.setQuantity(resultSet.getDouble("qty"));
            stock.setPrice(resultSet.getDouble("price"));
            stock.setLiter(resultSet.getDouble("liter"));
        }

        searchByStatement.close();

        return stock;
    }

    @Override
    public Stock getProductById(String productId) throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT stockid,product_id,productname,qty,price,liter FROM stock WHERE product_id=?");
        searchByStatement.setString(1, productId);

        ResultSet rs = searchByStatement.executeQuery();
        Stock stock = new Stock();

        while (rs.next()) {
            stock.setStockId(rs.getInt("stockid"));
            stock.setProductId(rs.getString("product_id"));
            stock.setProductName(rs.getString("productname"));
            stock.setQuantity(rs.getDouble("qty"));
            stock.setPrice(rs.getDouble("price"));
            stock.setLiter(rs.getDouble("liter"));
        }

        searchByStatement.close();
        rs.close();
      
        return stock;
    }
}
