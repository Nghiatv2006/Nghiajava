/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.wood.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.wood.dao.UserDAO;
import poly.wood.entity.User;
import poly.wood.util.XJdbc;
import poly.wood.util.XQuery;

/**
 *
 * @author Admin
 */
public class UserDAOImpl implements UserDAO{
     String createSql = "INSERT INTO Users(Username, Password, Enabled, Fullname, Photo, Manager) VALUES (?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Users SET Password=?, Enabled=?, Fullname=?, Photo=?, Manager=? WHERE Username=?";
    String deleteSql = "DELETE FROM Users WHERE Username=?";
    String findAllSql = "SELECT * FROM Users";
    String findByUsernameSql = "SELECT * FROM Users WHERE Username=?";

    @Override
public List<String> getAllUsernames() {
    String sql = "SELECT Username FROM Users";
    List<String> list = new ArrayList<>();
    try (ResultSet rs = XJdbc.executeQuery(sql)) {
        while (rs.next()) {
            list.add(rs.getString("Username"));
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return list;
}

    
    @Override
    public User create(User entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.getPhoto(),
            entity.isManager()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(User entity) {
        Object[] values = {
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.getPhoto(),
            entity.isManager(),
            entity.getUsername()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String username) {
      XJdbc.executeUpdate(deleteSql, username);
    }

    @Override
    public List<User> findAll() {
        return XQuery.getBeanList(User.class, findAllSql);
 }

    @Override
    public User findById(String username) {
        return XQuery.getSingleBean(User.class, findByUsernameSql, username);
  }
}
