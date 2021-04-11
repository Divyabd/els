package com.mindtree.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TeamEntity {

	@Id
	private int id;
	private String name;
	private String location;
	private int noOfPlayes;
	
	@OneToMany(mappedBy = "teams",targetEntity =PlayerEntity.class,fetch = FetchType.EAGER)
	@JsonIgnoreProperties
	private Set<PlayerEntity> playersList;

	public TeamEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamEntity(int id, String name, String location, int noOfPlayes, Set<PlayerEntity> playersList) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.noOfPlayes = noOfPlayes;
		this.playersList = playersList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfPlayes() {
		return noOfPlayes;
	}

	public void setNoOfPlayes(int noOfPlayes) {
		this.noOfPlayes = noOfPlayes;
	}

	public Set<PlayerEntity> getPlayersList() {
		return playersList;
	}

	public void setPlayersList(Set<PlayerEntity> playersList) {
		this.playersList = playersList;
	}

	

	
	
}
