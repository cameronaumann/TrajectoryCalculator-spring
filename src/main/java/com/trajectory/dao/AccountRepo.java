package com.trajectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trajectory.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
	
	public Account findByUsernameAndPassword(String username, String password);

}
