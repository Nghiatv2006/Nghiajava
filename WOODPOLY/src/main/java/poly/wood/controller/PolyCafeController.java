/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.wood.controller;

import javax.swing.JDialog;
import javax.swing.JFrame;
import poly.wood.ui.BillJDialog;
import poly.wood.ui.ChangePasswordJDialog;
import poly.wood.ui.HistoryJDialog;
import poly.wood.ui.LoginJDialog;
import poly.wood.ui.SalesJDialog;
import poly.wood.ui.WelcomeJDialog;
import poly.wood.ui.manager.BillManagerJDialog;
import poly.wood.ui.manager.CardManagerJDialog;
import poly.wood.ui.manager.CategoryManagerJDialog;
import poly.wood.ui.manager.WoodManagerJDialog;
import poly.wood.ui.manager.RevenueManagerJDialog;
import poly.wood.ui.manager.UserManagerJDialog;
import poly.wood.util.XDialog;

/**
 *
 * @author ADMIN
 */
public interface PolyCafeController {
    void init();
    default void exit(){
        if(XDialog.confirm("Bạn muốn kết thúc?")){
        System.exit(0);
        }
    }
    
    default void showJDialog(JDialog dialog){
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
      default void showWelcomeJDialog(JFrame frame){
          this.showJDialog(new WelcomeJDialog(frame,true));
      }
       default void showLoginJDialog(JFrame frame){
           this.showJDialog(new LoginJDialog(frame,true));
       }
       default void showChangePasswordJDialog(JFrame frame){ 
        this.showJDialog(new ChangePasswordJDialog(frame, true)); 
    } 
    default void showSalesJDialog(JFrame frame){ 
        this.showJDialog(new SalesJDialog(frame, true)); 
    } 
    default void showHistoryJDialog(JFrame frame){ 
        this.showJDialog(new HistoryJDialog(frame, true)); 
    } 
     
    default void showWoodManagerJDialog(JFrame frame){ 
        this.showJDialog(new WoodManagerJDialog(frame, true)); 
    } 
     default void showCategoryManagerJDialog(JFrame frame){ 
        this.showJDialog(new CategoryManagerJDialog(frame, true)); 
    } 
    default void showCardManagerJDialog(JFrame frame){ 
        this.showJDialog(new CardManagerJDialog(frame, true)); 
    } 
    default void showBillManagerJDialog(JFrame frame){ 
        this.showJDialog(new BillManagerJDialog(frame, true)); 
    } 
    default void showUserManagerJDialog(JFrame frame){ 
        this.showJDialog(new UserManagerJDialog(frame, true)); 
    } 
    default void showRevenueManagerJDialog(JFrame frame){ 
        this.showJDialog(new RevenueManagerJDialog(frame, true)); 
    }
}
