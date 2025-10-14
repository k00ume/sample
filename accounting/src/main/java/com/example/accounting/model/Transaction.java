package com.example.accounting.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private Long id;
    private LocalDate date;
    private String category;
    private BigDecimal amount;
    private String description;
}
