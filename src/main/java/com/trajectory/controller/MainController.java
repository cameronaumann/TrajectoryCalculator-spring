package com.trajectory.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.trajectory.model.Account;
import com.trajectory.model.Trajectory;
import com.trajectory.service.AccountService;
import com.trajectory.service.TrajectoryService;

@RestController
public class MainController {
	
	public AccountService accServ;
	public TrajectoryService trajServ;
	
	
	@Autowired
	public MainController(AccountService accServ, TrajectoryService trajServ) {
		this.accServ = accServ;
		this.trajServ = trajServ;
	}
	
	@PostMapping("/account/newAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public Account newAccount(@RequestBody String username, String password) {
		if (username == null || password == null ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing registration credentials");
		}
		return accServ.addAccount(username, password);
	}
	
	@GetMapping("/account/login")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Account login(@RequestBody String username, String password) {
		if (username == null || password == null ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing login credentials");
		}
		return accServ.login(username, password);
	}
	
	@PutMapping("/account/changePassword")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Account changePassword(@RequestBody Account account, String newPassword) {
		if (account.getPassword() == newPassword) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password already in use");
		}
		return accServ.changePassword(account, newPassword);	
	}
	
	@PostMapping("/addTrajectory")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Trajectory addTrajectory(@RequestBody Trajectory trajectory) {
		if (trajectory.getDate() == null || trajectory.getAngle() == null || trajectory.getHeight() == null || trajectory.getVelocity() == null || trajectory.getAccount() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing trajectory details");
		}
		return trajServ.addTrajectory(trajectory);
	}
	
	
	
	
	

}
