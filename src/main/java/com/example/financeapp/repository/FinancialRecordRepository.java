package com.example.financeapp.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.financeapp.entity.FinancialRecord;
import com.example.financeapp.entity.RecordType;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
 List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);

    List<FinancialRecord> findByUserId(Long userId);

      @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = 'INCOME'")
    Double getTotalIncome();

    @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = 'EXPENSE'")
    Double getTotalExpense();

    @Query("SELECT f.category, SUM(f.amount) FROM FinancialRecord f GROUP BY f.category")
    List<Object[]> getCategoryWiseData();

    @Query("SELECT MONTH(f.date), SUM(f.amount) FROM FinancialRecord f GROUP BY MONTH(f.date)")
    List<Object[]> getMonthlyData();
}
