package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PlayerEntity {

	
	@Id
	private int id;
	private String name;
	private int age;
	private String role;
	@ManyToOne
	@JsonIgnore
	private TeamEntity teams;

	public PlayerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerEntity(int id, String name, int age, String role, TeamEntity teams) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.role = role;
		this.teams = teams;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public TeamEntity getTeams() {
		return teams;
	}

	public void setTeams(TeamEntity teams) {
		this.teams = teams;
	}
	
}
