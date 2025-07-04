/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.wood.controller;

import poly.wood.entity.Bill;
import poly.wood.entity.Wood;

/**
 *
 * @author Nghia
 */
public interface WoodController extends CrudController<Wood>{
    void setBill(Bill bill); // nhận bill từ BillJDialog  
void open(); // hiển thị loại và đồ uống 
void fillCategories(); // tải và hiển thị loại đồ uống 
void fillDrinks(); //  tải và hiển thị đồ uống 
void addDrinkToBill(); // thêm đồ uống vào bill
    void chooseFile();
}
