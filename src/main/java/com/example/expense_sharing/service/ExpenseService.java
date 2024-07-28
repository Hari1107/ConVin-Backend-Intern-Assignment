package com.example.expense_sharing.service;

import com.example.expense_sharing.model.Expense;
import com.example.expense_sharing.model.Participant;
import com.example.expense_sharing.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {
        if (expense.getSplitType().equals("EQUAL")) {
            splitEqual(expense);
        } else if (expense.getSplitType().equals("EXACT")) {
            splitExact(expense);
        } else if (expense.getSplitType().equals("PERCENTAGE")) {
            splitPercentage(expense);
        }
        return expenseRepository.save(expense);
    }

    private void splitEqual(Expense expense) {
        int numParticipants = expense.getParticipants().size();
        double splitAmount = expense.getAmount() / numParticipants;
        for (Participant participant : expense.getParticipants()) {
            participant.setAmount(splitAmount);
        }
    }

    private void splitExact(Expense expense) {
        // Amounts are already set in the participants
    }

    private void splitPercentage(Expense expense) {
        double totalPercentage = 0;
        for (Participant participant : expense.getParticipants()) {
            totalPercentage += participant.getPercentage();
        }
        if (totalPercentage != 100) {
            throw new IllegalArgumentException("Percentages do not add up to 100");
        }
        for (Participant participant : expense.getParticipants()) {
            participant.setAmount(expense.getAmount() * participant.getPercentage() / 100);
        }
    }

    public Expense getExpense(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public List<Expense> getUserExpenses(Long userId) {
        // Implement logic to fetch expenses for a particular user
        return null;
    }

    public List<Expense> getOverallExpenses() {
        return expenseRepository.findAll();
    }
}
