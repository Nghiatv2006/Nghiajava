/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.wood.dao;

import java.util.List;
import poly.wood.entity.Wood;
public interface WoodDao extends CrudDAO<Wood, String>{
    List<Wood> findByCategoryId(String Categoryid);
}
