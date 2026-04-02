package com.example.financeapp.service;

import com.example.financeapp.dto.response.CategoryWiseResponse;
import com.example.financeapp.dto.response.DashboardSummaryResponse;
import com.example.financeapp.dto.response.MonthlyTrendResponse;
import java.util.List;
public interface DashboardService {
 DashboardSummaryResponse getSummary();

    List<CategoryWiseResponse> getCategoryWise();

    List<MonthlyTrendResponse> getMonthlyTrends();
    
} 
