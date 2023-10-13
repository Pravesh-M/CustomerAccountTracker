package com.practice.customer.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private double balance;

}
