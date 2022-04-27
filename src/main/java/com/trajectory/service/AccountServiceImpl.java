package com.trajectory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trajectory.dao.AccountRepo;
import com.trajectory.model.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	public AccountRepo accRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepo accRepo) {
		this.accRepo = accRepo;
	}

	@Override
	public Account addAccount(String username, String password) {
		return accRepo.save(new Account());
	}

	@Override
	public Account login(String username, String password) {
		return accRepo.findByUsernameAndPassword(username, password);
	}
	
	
}
