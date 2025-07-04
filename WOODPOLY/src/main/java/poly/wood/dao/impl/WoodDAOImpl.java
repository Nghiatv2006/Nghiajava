package poly.wood.dao.impl;

import java.util.List;
import poly.wood.entity.Wood;
import poly.wood.util.XJdbc;
import poly.wood.util.XQuery;
import poly.wood.dao.WoodDao;

/**
 *
 * @author Admin
 */
public class WoodDAOImpl implements WoodDao {

    String createSql = "INSERT INTO Woods(Id, Name, UnitPrice, Discount, Image, Available, CategoryId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Woods SET Name=?, UnitPrice=?, Discount=?, Image=?, Available=?, CategoryId=? WHERE Id=?";
    String deleteSql = "DELETE FROM Woods WHERE Id=?";
    String findAllSql = "SELECT * FROM Woods";
    String findByIdSql = "SELECT * FROM Woods WHERE Id=?";
    String findByCategoryIdSql = "SELECT * FROM Woods WHERE CategoryId=?";

    @Override
    public List<Wood> findByCategoryId(String categoryId) {
        return XQuery.getBeanList(Wood.class, findByCategoryIdSql, categoryId);
    }

    @Override
    public Wood create(Wood entity) {
        Object[] values = {
            entity.getId(),
            entity.getName(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getImage(),
            entity.isAvailable(),
            entity.getCategoryId()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Wood entity) {
        Object[] values = {
            entity.getName(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getImage(),
            entity.isAvailable(),
            entity.getCategoryId(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Wood> findAll() {
        return XQuery.getBeanList(Wood.class, findAllSql);
    }

    @Override
    public Wood findById(String id) {
        return XQuery.getSingleBean(Wood.class, findByIdSql, id);
    }
}
