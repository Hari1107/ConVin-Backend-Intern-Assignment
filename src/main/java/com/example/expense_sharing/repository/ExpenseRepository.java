package com.example.expense_sharing.repository;

import com.example.expense_sharing.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
