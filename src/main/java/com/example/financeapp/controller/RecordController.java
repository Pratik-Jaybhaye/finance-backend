package com.example.financeapp.controller;

import com.example.financeapp.dto.request.RecordRequest;
import com.example.financeapp.dto.response.RecordResponse;
import com.example.financeapp.service.RecordService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    //  CREATE RECORD
    @PostMapping
    public ResponseEntity<RecordResponse> createRecord(@Valid @RequestBody RecordRequest request) {
        return ResponseEntity.ok(recordService.createRecord(request));
    }

    //  GET ALL RECORDS
    @GetMapping
    public ResponseEntity<List<RecordResponse>> getAllRecords() {
        return ResponseEntity.ok(recordService.getAllRecords());
    }

    //  UPDATE RECORD
    @PutMapping("/{id}")
    public ResponseEntity<RecordResponse> updateRecord(
            @PathVariable Long id,
            @Valid @RequestBody RecordRequest request) {

        return ResponseEntity.ok(recordService.updateRecord(id, request));
    }

    //  DELETE RECORD
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return ResponseEntity.ok("Record deleted successfully");
    }

    //  FILTER RECORDS 
    @GetMapping("/filter")
    public ResponseEntity<List<RecordResponse>> filterRecords(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String type) {

        return ResponseEntity.ok(recordService.filterRecords(category, type));
    }
}