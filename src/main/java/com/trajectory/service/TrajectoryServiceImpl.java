package com.trajectory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trajectory.dao.TrajectoryRepo;
import com.trajectory.model.Account;
import com.trajectory.model.Trajectory;

@Service
public class TrajectoryServiceImpl implements TrajectoryService {
	
	public TrajectoryRepo trajRepo;
	
	@Autowired
	public TrajectoryServiceImpl(TrajectoryRepo trajRepo) {
		this.trajRepo = trajRepo;
	}
	
	@Override
	public List<Trajectory> getTrajectories(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTrajectory(Trajectory trajectory) {
		
		return true;
		
	}

	@Override
	public boolean removeTrajectory(Trajectory trajectory) {
		// TODO Auto-generated method stub
		return false;
	}

}
