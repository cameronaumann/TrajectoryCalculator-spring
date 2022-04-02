package com.trajectory.controller;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private ModelMapper mapper;
	
	
	@Autowired
	public MainController(AccountService accServ ,TrajectoryService trajServ, ModelMapper mapper) {
		this.accServ = accServ;
		this.mapper = mapper;
		this.trajServ = trajServ;
	}
	
	private Account convertToEntity(AccountDto accountDto) {
		return mapper.map(accountDto, Account.class);
	}
	
	@PostMapping("/account/newAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public Account newAccount(@RequestBody AccountDto accountDto) {
		if (accountDto.getUsername() == null || accountDto.getPassword() == null ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing registration info");
		}
		Account acc = convertToEntity(accountDto);
		return accServ.addAccount(acc.getUsername(),acc.getPassword());
	}
	
	@GetMapping("/account/login")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Account login(@RequestBody AccountDto accountDto) {
		if (accountDto.getUsername() == null || accountDto.getPassword() == null ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing login credentials");
		}
		Account acc = convertToEntity(accountDto);
		return accServ.login(acc.getUsername(),acc.getPassword());
	}
	
	@PostMapping("/addTrajectory")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public boolean addTrajectory(@RequestBody Trajectory trajectory) {
		if (trajectory.getDate() == null || trajectory.getAngle() == null || trajectory.getHeight() == null || trajectory.getVelocity() == null || trajectory.getAccount() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing trajectory details");
		}
		return trajServ.addTrajectory(trajectory);
	}
	
	
	
	
	

}
