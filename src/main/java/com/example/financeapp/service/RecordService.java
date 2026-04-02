package com.example.financeapp.service;

import com.example.financeapp.dto.request.RecordRequest;
import com.example.financeapp.dto.response.RecordResponse;
import java.util.List;
public interface RecordService {

    RecordResponse createRecord(RecordRequest request);

    List<RecordResponse> getAllRecords();

    RecordResponse updateRecord(Long id, RecordRequest request);

    void deleteRecord(Long id);
    List<RecordResponse> filterRecords(String category, String type);
    
} 
