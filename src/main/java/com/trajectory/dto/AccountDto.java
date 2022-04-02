package com.trajectory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
	
	Integer accountId;
	String username;
	String password;
	
}
