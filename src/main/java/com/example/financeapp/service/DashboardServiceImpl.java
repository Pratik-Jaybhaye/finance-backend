package com.example.financeapp.service;

import com.example.financeapp.dto.response.*;
import com.example.financeapp.repository.FinancialRecordRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final FinancialRecordRepository recordRepository;

    public DashboardServiceImpl(FinancialRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    //  1. SUMMARY 
    @Override
    public DashboardSummaryResponse getSummary() {

        Double totalIncome = recordRepository.getTotalIncome();
        Double totalExpense = recordRepository.getTotalExpense();

        // null safety
        totalIncome = (totalIncome == null) ? 0.0 : totalIncome;
        totalExpense = (totalExpense == null) ? 0.0 : totalExpense;

        Double netBalance = totalIncome - totalExpense;

        DashboardSummaryResponse res = new DashboardSummaryResponse();
        res.setTotalIncome(totalIncome);
        res.setTotalExpense(totalExpense);
        res.setNetBalance(netBalance);

        return res;
    }

    // 2. CATEGORY-WISE
    @Override
    public List<CategoryWiseResponse> getCategoryWise() {

        List<Object[]> data = recordRepository.getCategoryWiseData();

        return data.stream().map(obj -> {
            CategoryWiseResponse res = new CategoryWiseResponse();
            res.setCategory((String) obj[0]);
            res.setTotalAmount((Double) obj[1]);
            return res;
        }).toList();
    }

    //  3. MONTHLY TRENDS
    @Override
    public List<MonthlyTrendResponse> getMonthlyTrends() {

        List<Object[]> data = recordRepository.getMonthlyData();

        return data.stream().map(obj -> {

            Integer month = (Integer) obj[0];
            Double total = (Double) obj[1];

            MonthlyTrendResponse res = new MonthlyTrendResponse();
            res.setMonth(getMonthName(month));

            // simplified (same value both for now)
            res.setTotalIncome(total);
            res.setTotalExpense(total);

            return res;

        }).toList();
    }

    // HELPER METHOD
    private String getMonthName(int month) {

        return switch (month) {
            case 1 -> "JAN";
            case 2 -> "FEB";
            case 3 -> "MAR";
            case 4 -> "APR";
            case 5 -> "MAY";
            case 6 -> "JUN";
            case 7 -> "JUL";
            case 8 -> "AUG";
            case 9 -> "SEP";
            case 10 -> "OCT";
            case 11 -> "NOV";
            case 12 -> "DEC";
            default -> "UNKNOWN";
        };
    }
}