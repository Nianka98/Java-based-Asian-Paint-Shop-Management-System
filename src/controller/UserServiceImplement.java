package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import facade.User;
import util.ConnectDatabase;

public class UserServiceImplement implements UserService {

    @Override
    public void save(User user) throws SQLException {
        PreparedStatement saveStatement = ConnectDatabase.getConnection()
                .prepareStatement("INSERT INTO user_ (firstname,lastname,email,username,password,status,usertype) VALUES(?,?,?,?,?,?,?)");
        saveStatement.setString(1, user.getFirstName());
        saveStatement.setString(2, user.getLastName());
        saveStatement.setString(3, user.getEmail());
        saveStatement.setString(4, user.getUsername());
        saveStatement.setString(5, user.getPassword());
        saveStatement.setInt(6, user.getStatus());
        saveStatement.setInt(7, user.getUserType());

        saveStatement.execute();
        saveStatement.close();
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement updateStatement = ConnectDatabase.getConnection()
                .prepareStatement("UPDATE user_ SET firstname=?, lastname=?, email=?, username=?, password=?, status=?, usertype=? WHERE userid=?");
        updateStatement.setString(1, user.getFirstName());
        updateStatement.setString(2, user.getLastName());
        updateStatement.setString(3, user.getEmail());
        updateStatement.setString(4, user.getUsername());
        updateStatement.setString(5, user.getPassword());
        updateStatement.setInt(6, user.getStatus());
        updateStatement.setInt(7, user.getUserType());
        updateStatement.setInt(8, user.getUserId());
        updateStatement.execute();
        updateStatement.close();
    }

    @Override
    public void delete(int userId) throws SQLException {
        PreparedStatement deleteStatement = ConnectDatabase.getConnection()
                .prepareStatement("DELETE FROM user_ WHWRE userid=?");
        deleteStatement.setInt(1, userId);
        deleteStatement.executeUpdate();
        deleteStatement.close();
    }

    @Override
    public List<User> loadAllUsers() throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT userid,firstname,lastname,email,username,password,status,usertype FROM user_");

        ResultSet rs = searchByStatement.executeQuery();

        List<User> userList = new ArrayList();

        while (rs.next()) {
            User user = new User();
            user.setUserId(rs.getInt("userid"));
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setStatus(rs.getInt("status"));
            user.setUserType(rs.getInt("usertype"));
            userList.add(user);
        }

        searchByStatement.close();

        return userList;
    }

    @Override
    public User searchByString(String searchString) throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT userid,firstname,lastname,email,username,password,status,usertype FROM user_ WHERE firstname like ? OR lastname like ? OR username like ?");
        searchByStatement.setString(1, searchString + "%");
        searchByStatement.setString(2, searchString + "%");
        searchByStatement.setString(3, searchString + "%");

        ResultSet rs = searchByStatement.executeQuery();
        User user = new User();

        while (rs.next()) {
            user.setUserId(rs.getInt("userid"));
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setStatus(rs.getInt("status"));
            user.setUserType(rs.getInt("usertype"));
        }

        searchByStatement.close();

        return user;
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        PreparedStatement searchByStatement = ConnectDatabase.getConnection()
                .prepareStatement("SELECT userid,firstname,lastname,email,username,password,status,usertype FROM user_ WHERE userid=?");
        searchByStatement.setInt(1, userId);

        ResultSet rs = searchByStatement.executeQuery();
        User user = new User();

        while (rs.next()) {
            user.setUserId(rs.getInt("userid"));
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setStatus(rs.getInt("status"));
            user.setUserType(rs.getInt("usertype"));
        }

        searchByStatement.close();

        return user;
    }

    @Override
    public User userLogin(String userName, String password) throws SQLException {
        PreparedStatement stmt = ConnectDatabase.getConnection()
                .prepareStatement("select userid,firstname,lastname,email,username,password,status,usertype from user_ where username=? and password=?");
        stmt.setString(1, userName);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        User user = null;

        if (rs.next()) {
            user = new User();
            user.setUserId(rs.getInt("userid"));
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setStatus(rs.getInt("status"));
            user.setUserType(rs.getInt("usertype"));
        }

        return user;
    }
}
