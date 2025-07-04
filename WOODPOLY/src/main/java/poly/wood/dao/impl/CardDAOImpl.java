/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.wood.dao.impl;

import java.util.List;
import poly.wood.dao.CardDAO;
import poly.wood.entity.Card;
import poly.wood.util.XJdbc;
import poly.wood.util.XQuery;

/**
 *
 * @author Admin
 */
public class CardDAOImpl implements CardDAO{
    String createSql = "INSERT INTO Cards(Id, Status) VALUES(?, ?)";
    String updateSql = "UPDATE Cards SET Status=? WHERE Id=?";
    String deleteSql = "DELETE FROM Cards WHERE Id=?";
    String findAllSql = "SELECT * FROM Cards";
    String findByIdSql = "SELECT * FROM Cards WHERE Id=?";
    
    @Override
    public Card create(Card entity) {
        Object[] values = {
            entity.getId(),
            entity.getStatus()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Card entity) {
        Object[] values = {
            entity.getStatus(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Card> findAll() {
        return XQuery.getBeanList(Card.class, findAllSql);
    }

    @Override
    public Card findById(Integer id) {
         return XQuery.getSingleBean(Card.class, findByIdSql, id);
    }
}
