package com.trajectory.controller;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.trajectory.dto.AccountDto;
import com.trajectory.model.Account;
import com.trajectory.model.Trajectory;
import com.trajectory.service.AccountService;
import com.trajectory.service.TrajectoryService;

@RestController
public class MainController {
	
	private AccountService accServ;
	private TrajectoryService trajServ;
//	private ModelMapper mapper;
	
	
	@Autowired
	public MainController(AccountService accServ ,TrajectoryService trajServ /*, ModelMapper mapper*/) {
		this.accServ = accServ;
//		this.mapper = mapper;
		this.trajServ = trajServ;
	}
	
//	private Account convertToEntity(AccountDto accountDto) {
//		return mapper.map(accountDto, Account.class);
//	}
	
	@PostMapping("/account/newAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public Account newAccount(@RequestBody Account account) {
		if (account.getUsername() == null || account.getPassword() == null ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing registration info");
		}
//		Account acc = convertToEntity(account);
		return accServ.addAccount(account.getUsername(), account.getPassword());
	}
	
	@GetMapping("/account/login")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Account login(@RequestBody Account account) {
		if (account.getUsername() == null || account.getPassword() == null ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing login credentials");
		}
//		Account acc = convertToEntity(accountDto);
		return accServ.login(account.getUsername(), account.getPassword());
	}
	
	@PostMapping("/addTrajectory")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addTrajectory(@RequestBody Trajectory trajectory) {
		if (trajectory.getDate() == null || trajectory.getAngle() == null || trajectory.getHeight() == null || trajectory.getVelocity() == null || trajectory.getAccount() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing trajectory details");
		}
		trajServ.addTrajectory(trajectory);
	}
	
	@PostMapping("/removeTrajectory")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void removeTrajectory(@RequestBody Trajectory trajectory) {
		trajServ.removeTrajectory(trajectory);
		
	}
	
	@GetMapping("/displayTrajectories")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody List<Trajectory> displayTrajectories(Account acc) {
		return trajServ.getTrajectories(acc);
	}

}
