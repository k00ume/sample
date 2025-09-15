package com.example.accounting.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Transaction {
    private Long id;
    private LocalDate date;
    private String category;
    private BigDecimal amount;
    private String description;
}
