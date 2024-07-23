package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.Accountservice; 

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private Accountservice accountService; 

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
		Account createdAccount =accountService.createAccount(account);
        return createdAccount;
    }
    @GetMapping("/{accountNumber}")
    public Account getAccountDetailsByAccountNumber(@PathVariable Long accountNumber) {
    
		Account getDetails=accountService.getAccountDetailsByAccountNumber(accountNumber);
		return  getDetails;
    }
    @GetMapping("/All")
    public List<Account> getAllAccountDetails(){
    	 return accountService.getAllAccountDetails();
    }
    
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account  depositAmount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account deposit=accountService.depositAmount(accountNumber, amount);
    	return deposit;
    }
    
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAmount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account withdraw=accountService.withdrawAmount(accountNumber, amount);
    	return withdraw;
    	
    }
    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber){
		accountService.closeAccount(accountNumber);
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
    	
    }
}
