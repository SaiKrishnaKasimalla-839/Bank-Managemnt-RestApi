package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface Accountservice { 
    Account createAccount(Account account);
    Account getAccountDetailsByAccountNumber(Long accountNumber); 
    List<Account> getAllAccountDetails();
    Account depositAmount(Long accountNumber, Double amount); 
    Account withdrawAmount(Long accountNumber, Double amount); 
    void closeAccount(Long accountNumber);
	Account createAccount(List<Account> account); 
}
