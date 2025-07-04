/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.wood.dao;

import java.util.Date;
import java.util.List;
import poly.wood.entity.Bill;

public interface BillDAO extends CrudDAO<Bill, Long> {

    List<Bill> findByUsername(String username);

    List<Bill> findByCardId(Integer cardId);

    public List<Bill> findByTimeRange(Date begin, Date end);
    // LAB 6
     public Bill findServicingByCardId(Integer cardId);
     List<Bill> findByUserAndTimeRange(String username, Date begin, Date end); 
}
