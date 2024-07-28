package com.example.expense_sharing.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String description;
    private String splitType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Participant> participants;

    // getters and setters
}
