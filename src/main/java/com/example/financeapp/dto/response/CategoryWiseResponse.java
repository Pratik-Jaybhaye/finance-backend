package com.example.financeapp.dto.response;

public class CategoryWiseResponse {
     private String category;
    public String getCategory() {
        return category;
    }
     public void setCategory(String category) {
         this.category = category;
     }
     public Double getTotalAmount() {
         return totalAmount;
     }
     public void setTotalAmount(Double totalAmount) {
         this.totalAmount = totalAmount;
     }
    private Double totalAmount;
    
}
