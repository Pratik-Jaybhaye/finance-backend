package com.example.financeapp.controller;

import com.example.financeapp.dto.response.CategoryWiseResponse;
import com.example.financeapp.dto.response.DashboardSummaryResponse;
import com.example.financeapp.dto.response.MonthlyTrendResponse;
import com.example.financeapp.service.DashboardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    // 1. SUMMARY 
    @GetMapping("/summary")
    public ResponseEntity<DashboardSummaryResponse> getSummary() {
        return ResponseEntity.ok(dashboardService.getSummary());
    }

    //  2. CATEGORY-WISE
    @GetMapping("/category-wise")
    public ResponseEntity<List<CategoryWiseResponse>> getCategoryWise() {
        return ResponseEntity.ok(dashboardService.getCategoryWise());
    }

    //  3. MONTHLY TRENDS
    @GetMapping("/monthly")
    public ResponseEntity<List<MonthlyTrendResponse>> getMonthlyTrends() {
        return ResponseEntity.ok(dashboardService.getMonthlyTrends());
    }
}