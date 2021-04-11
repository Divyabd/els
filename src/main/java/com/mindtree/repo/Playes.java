package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.PlayerEntity;

public interface Playes  extends JpaRepository<PlayerEntity, Integer>{
	public PlayerEntity findById(int id);
    public PlayerEntity findByName(String name);

}
