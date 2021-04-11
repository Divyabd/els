package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.TeamEntity;

public interface Teams  extends JpaRepository<TeamEntity, Integer>{
	public TeamEntity findByName(String name);
	public TeamEntity findById(int id);
	
}
