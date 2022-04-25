package com.trajectory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trajectory.model.Trajectory;

@Repository
public interface TrajectoryRepo extends JpaRepository<Trajectory, Integer> {
	
	public List<Trajectory> findAllByAcccountId(int accoundId);

}
