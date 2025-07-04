/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.wood.dao.impl;

import java.util.List;
import poly.wood.dao.BillDetailDAO;
import poly.wood.entity.BillDetail;
import poly.wood.util.XJdbc;
import poly.wood.util.XQuery;

/**
 *
 * @author Admin
 */
public class BillDetailDAOImpl implements BillDetailDAO{
    String createSql = "INSERT INTO BillDetails(BillId, WoodId, UnitPrice, Discount, Quantity) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE BillDetails SET BillId=?, WoodId=?, UnitPrice=?, Discount=?, Quantity=? WHERE Id=?";
    String deleteSql = "DELETE FROM BillDetails WHERE Id=?";
    
    String findAll = """ 
                        SELECT bd.*, d.name AS drinkName  
                        FROM BillDetails bd JOIN Woods d ON d.Id=bd.WoodId 
                        """;
    String findByIdSql = """
                         SELECT bd.*, d.name AS drinkName  
                         FROM BillDetails bd JOIN Woods d ON d.Id=bd.WoodId WHERE bd.Id=?
                         """;
    String findByBillIdSql = """
                             SELECT bd.*, d.name AS drinkName  
                             FROM BillDetails bd JOIN Woods d ON d.Id=bd.WoodId WHERE bd.BillId=?
                             """;
    String findByDrinkIdSql = """
                              SELECT bd.*, d.name AS drinkName  
                              FROM BillDetails bd JOIN Woods d ON d.Id=bd.WoodId WHERE bd.WoodId=? 
                              """;


    @Override
    public List<BillDetail> findByBillId(Long billId) {
        return XQuery.getBeanList(BillDetail.class, findByBillIdSql, billId);
    }

    @Override
    public List<BillDetail> findByDrinkId(String drinkId) {
        return XQuery.getBeanList(BillDetail.class, findByDrinkIdSql, drinkId);
    }

    //Không cần truyền Id vì đây là IDENTITY.
//BillId, DrinkId, UnitPrice, Discount, Quantity
    @Override
    public BillDetail create(BillDetail entity) {
        Object[] values = {
            entity.getBillId(),
            entity.getWoodId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(BillDetail entity) {
        Object[] values = {
            entity.getBillId(),
            entity.getWoodId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<BillDetail> findAll() {
        return XQuery.getBeanList(BillDetail.class, findAll);
    }

    @Override
    public BillDetail findById(Long id) {
        return XQuery.getSingleBean(BillDetail.class, findByIdSql, id);
    }
}
