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
		return trajRepo.findAllByAcccountId(account.getAccountId());
	}

	@Override
	public void addTrajectory(Trajectory trajectory) {
		trajRepo.save(trajectory);
		
	}

	@Override
	public void removeTrajectory(Trajectory trajectory) {
		trajRepo.delete(trajectory);
	}	

}
