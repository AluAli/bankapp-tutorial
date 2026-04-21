package com.masu.services;

import com.masu.models.Transaction;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TransactionService {

    //private TransactionRepository transactionRepository;
    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction getTransaction(String id) {
        return transactions.stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("transaction id was not found"));
    }

    public void updateTransaction(Transaction transaction) {
        transactions.stream()
                .filter(tran -> transaction.getId().equals(tran.getId()))
                .findFirst()
                .ifPresent(t -> {
                    t.setAmount(checkIfEmpty(transaction.getAmount()) ? t.getAmount() : transaction.getAmount());
                    t.setDate(checkIfEmpty(transaction.getDate()) ? t.getDate() : transaction.getDate());
                    t.setNameOfReceiverOrSender(checkIfEmpty(transaction.getNameOfReceiverOrSender()) ? t.getNameOfReceiverOrSender() : transaction.getNameOfReceiverOrSender());
                });
    }

    private <T> boolean checkIfEmpty(T o) {
        if (o == null || o == "") return true;
        return false;
    }

    public void deleteTransaction(String id) {
        transactions.removeIf(transaction -> transaction.getId().equals(id));
    }
}
