/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.wood.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.Date;
/**
 *
 * @author Nghia
 */
public class Revenue {
     @AllArgsConstructor
 @NoArgsConstructor
 @Builder
 @Data
 public static class ByCategory {
          private String category;
 private double revenue;
 private int quantity;
 private double minPrice;
 private double maxPrice;
 private double avgPrice;
 }
 @AllArgsConstructor
 @NoArgsConstructor
 @Builder
 @Data
 public static class ByUser {
      private String user;
 private double revenue;
 private int quantity;
 private Date firstTime;
 private Date lastTime;
 }
}
