/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poly.wood.util;

import java.sql.ResultSet;
import java.util.List;
import poly.wood.entity.Category;
import poly.wood.util.XJdbc;

/**
 *
 * @author ADMIN
 */
public class Test {
    public static void main(String[] args) {
        //Thêm mới 
        String sql = "INSERT INTO Categories (Id, Name) VALUES(?, ?)"; 
        XJdbc.executeUpdate(sql, "C01", "Loại 1"); 
        XJdbc.executeUpdate(sql, "C02", "Loại 2"); 
        
        //Truy vấn nhiều bản ghi 
        String sql1 = "SELECT * FROM Categories WHERE Name LIKE ?"; 
        ResultSet rs = XJdbc.executeQuery(sql, "%Loại%");
        
        //Truy xuất nhiều bản ghi và chuyển đổi sang List<Bean> 
        String sql2 = "SELECT * FROM Categories WHERE Name LIKE ?"; 
        List<Category> beans = XQuery.getBeanList(Category.class, sql, "%Loại%");
        
        
        //Truy xuất một bản ghi và chuyển đổi sang Bean 
        String sql3 = "SELECT * FROM Categories WHERE Id=?"; 
        Category bean = XQuery.getSingleBean(Category.class, sql, "C02"); 
        
        //Truy vấn 1 giá trị 
        String sql4 = "SELECT max(Id) FROM Categories WHERE Name LIKE ?"; 
        String id = XJdbc.getValue(sql, "%Loại%");
    }
    
}
