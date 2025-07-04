/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.wood.dao;

import java.util.List;
import poly.wood.entity.User;

/**
 *
 * @author Nghia
 */
public interface UserDAO extends  CrudDAO<User, String>{
    List<String> getAllUsernames();

}
