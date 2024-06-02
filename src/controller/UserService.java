package controller;

import java.sql.SQLException;
import java.util.List;
import facade.User;

public interface UserService {

    public void save(User user) throws SQLException;

    public User userLogin(String userName,String password) throws SQLException;
    
    public void update(User user) throws SQLException;

    public void delete(int userId) throws SQLException;

    public User getUserById(int userId) throws SQLException;
    
    public List<User> loadAllUsers() throws SQLException;

    public User searchByString(String searchString) throws SQLException;
}
