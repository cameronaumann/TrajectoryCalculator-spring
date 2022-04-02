package com.trajectory.service;

import com.trajectory.model.Account;

public interface AccountService {

	public Account addAccount(String username, String password);
	
	public Account login(String username, String password);
	
}
