package com.example.financeapp.service;

import com.example.financeapp.dto.request.RecordRequest;
import com.example.financeapp.dto.response.RecordResponse;
import com.example.financeapp.entity.FinancialRecord;
import com.example.financeapp.entity.RecordType;
import com.example.financeapp.entity.User;
import com.example.financeapp.exception.ResourceNotFoundException;
import com.example.financeapp.repository.FinancialRecordRepository;
import com.example.financeapp.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
   
    private final UserRepository userRepository;

    private final FinancialRecordRepository recordRepository;
   

    public RecordServiceImpl(FinancialRecordRepository recordRepository,  UserRepository userRepository) {
        this.recordRepository = recordRepository;
         this.userRepository = userRepository;
    }

    //  CREATE
    @Override
    public RecordResponse createRecord(RecordRequest request) {

        FinancialRecord record = new FinancialRecord();

        record.setAmount(request.getAmount());
        record.setType(RecordType.valueOf(request.getType().toUpperCase()));
        record.setCategory(request.getCategory());
        record.setDate(request.getDate());
        record.setDescription(request.getDescription());
        User user = userRepository.findAll().stream()
        .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    record.setUser(user);

        recordRepository.save(record);

        return mapToResponse(record);
    }

    //  GET ALL
    @Override
    public List<RecordResponse> getAllRecords() {

        return recordRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    //  UPDATE
    @Override
    public RecordResponse updateRecord(Long id, RecordRequest request) {

        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAmount(request.getAmount());
        record.setType(RecordType.valueOf(request.getType().toUpperCase()));
        record.setCategory(request.getCategory());
        record.setDate(request.getDate());
        record.setDescription(request.getDescription());

        recordRepository.save(record);

        return mapToResponse(record);
    }

    //  DELETE
    @Override
    public void deleteRecord(Long id) {

        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        recordRepository.delete(record);
    }

    //  FILTER
    @Override
    public List<RecordResponse> filterRecords(String category, String type) {

        List<FinancialRecord> records = recordRepository.findAll();

        return records.stream()
                .filter(r -> category == null || r.getCategory().equalsIgnoreCase(category))
                .filter(r -> type == null || r.getType().name().equalsIgnoreCase(type))
                .map(this::mapToResponse)
                .toList();
    }

    //  MAPPER
    private RecordResponse mapToResponse(FinancialRecord record) {

        RecordResponse res = new RecordResponse();

        res.setId(record.getId());
        res.setAmount(record.getAmount());
        res.setType(record.getType().name());
        res.setCategory(record.getCategory());
        res.setDate(record.getDate());
        res.setDescription(record.getDescription());
        res.setCreatedBy(record.getUser().getName());

        return res;
    }
}
