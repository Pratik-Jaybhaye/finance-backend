package com.example.financeapp.dto.response;

public class MonthlyTrendResponse {
    private String month;
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public Double getTotalIncome() {
        return totalIncome;
    }
    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }
    public Double getTotalExpense() {
        return totalExpense;
    }
    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }
    private Double totalIncome;
    private Double totalExpense;

}
