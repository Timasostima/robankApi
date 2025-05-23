package dev.tymurkulivar.robank_backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.tymurkulivar.robank_backend.entities.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {
    private String name;
    private Double amount;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private LocalTime time;

    private Long categoryId;

    public BillDTO(Bill bill) {
        this.name = bill.getName();
        this.amount = bill.getAmount();
        this.date = bill.getDate();
        this.time = bill.getTime();
        this.categoryId = bill.getCategory().getId();
    }
}
