package com.trajectory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "trajectories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Trajectory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer trajectoryId;
	String date;
	Double angle;
	Double height;
	Double velocity;
	
	@ManyToOne
	@JoinColumn(referencedColumnName =  "accountId")
	Account account;
	
	
	

}
