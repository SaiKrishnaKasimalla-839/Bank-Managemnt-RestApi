package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.Repository.AccountRepository;

@Service
public  class AccountService2 implements Accountservice {

    @Autowired
    private AccountRepository repo;

 
	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> account=repo.findById(accountNumber);
		if (account.isEmpty()) {
			throw new RuntimeException("Account is Not Created");
		}
		Account account_found =account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> getAll=repo.findAll();
		return getAll;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not Persent");
		}
		Account accountPresent=account.get();
		Double totalbalance=accountPresent.getAccountBalance()+amount;
		accountPresent.setAccountBalance(totalbalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> with=repo.findById(accountNumber);
		if(with.isEmpty()) {
			throw new RuntimeException("Account Is Not Exist");
		}
		Account present=with.get();
		Double minusbalance=present.getAccountBalance()-amount;
		present.setAccountBalance(minusbalance);
		repo.save(present);
		return present;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
		
	}

	@Override
	public Account createAccount(Account account) {
		  return repo.save(account);
	}

	

}