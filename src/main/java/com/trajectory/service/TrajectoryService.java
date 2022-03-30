package com.trajectory.service;

import java.util.List;

import com.trajectory.model.Account;
import com.trajectory.model.Trajectory;

public interface TrajectoryService {

	public List<Trajectory> getTrajectories(Account account);
	
	public Trajectory addTrajectory(Trajectory trajectory);
	
	public boolean removeTrajectory(Trajectory trajectory);

}
