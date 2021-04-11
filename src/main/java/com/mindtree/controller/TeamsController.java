package com.mindtree.controller;

import java.util.ArrayList;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.PlayerEntity;
import com.mindtree.entity.TeamEntity;
import com.mindtree.exception.serviceException.ServiceException;
import com.mindtree.service.TeamsService;
//import com.sun.org.slf4j.internal.LoggerFactory;

@RestController
@RequestMapping(path="/team")
public class TeamsController {
	private final Logger logger=org.slf4j.LoggerFactory.getLogger(this.getClass());
	@Autowired
	public TeamsService srv;
	
	
	@PostMapping("/tinsert")
	public ResponseEntity<?> addTrack(@RequestBody TeamEntity te) {
		String s;
		try {
		srv.addTeams(te);
			return new ResponseEntity<>("succesfully Team added\n" , HttpStatus.CREATED);
		} catch (ServiceException e) {
			System.out.println("Controller error" + e);
			s = e + "error";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/pinsert/{id}")
	public ResponseEntity<?> addPlayer(@RequestBody PlayerEntity pe,@PathVariable("id") int id) {
		String s;
		try {
		srv.addPlayes(pe,id);
		
			return new ResponseEntity<>("succesfully Team added\n" , HttpStatus.CREATED);
		} catch (ServiceException e) {
			System.out.println("Controller error" + e);
			s = e + "error";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	
	@GetMapping("/getTeam/{name}")
	public ResponseEntity<?> getBYTrack(@PathVariable("name") String name) {
		String s;
		try {
			srv.getByName(name);
		TeamEntity details = srv.getByName(name);
			return new ResponseEntity<>(details, HttpStatus.OK);
		} catch (ServiceException e) {
			s = e + "error";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getall() {
		String s;
		try {
			ArrayList<TeamEntity> details=new  ArrayList<TeamEntity>();
		details = srv.getall();
			return new ResponseEntity<>(details, HttpStatus.OK);
		} catch (ServiceException e) {
			s = e + "error";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		String s;
		try {
			String details = srv.deletePlayer(id);
			logger.debug("addersuccesfully congrats!!!!");
			return new ResponseEntity<>(details, HttpStatus.OK);
		} catch (ServiceException e) {
			s = e + "error";
		}
		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/tupdate/{id}")
	public ResponseEntity<?> updateName(@PathVariable("id") int id, @RequestBody String name) {
		String s;
		try {
			String details = srv.updateLact(name, id);
			return new ResponseEntity<>(details, HttpStatus.OK);
		} catch (ServiceException e) {
			s = e + "error";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}
}
