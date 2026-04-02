package com.example.financeapp.dto.request;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RecordRequest {
     @NotNull
    private Double amount;

    public Double getAmount() {
        return amount;
    }

     public void setAmount(Double amount) {
         this.amount = amount;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public String getCategory() {
         return category;
     }

     public void setCategory(String category) {
         this.category = category;
     }

     public LocalDate getDate() {
         return date;
     }

     public void setDate(LocalDate date) {
         this.date = date;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

    @NotBlank
    private String type;

    @NotBlank
    private String category;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String description;
}
