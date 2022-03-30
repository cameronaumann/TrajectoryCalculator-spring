package com.trajectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trajectory.model.Trajectory;

@Repository
public interface TrajectoryRepo extends JpaRepository<Trajectory, Integer> {

}
