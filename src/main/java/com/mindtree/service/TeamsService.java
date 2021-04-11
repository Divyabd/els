package com.mindtree.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.PlayerEntity;
import com.mindtree.entity.TeamEntity;
import com.mindtree.exception.serviceException.ServiceException;
import com.mindtree.repo.Playes;
import com.mindtree.repo.Teams;

@Service
public class TeamsService {

	@Autowired
	public Playes pRepo;

	@Autowired
	public Teams tRepo;

	public TeamEntity addTeams(TeamEntity te) throws ServiceException {
		try {
			int id = te.getId();

			TeamEntity em = null;
			em = tRepo.findById(id);
			if (em == null) {
				tRepo.save(te);
				return te;
			} else {
				throw new ServiceException("id already present in database");
			}
		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException(e);
		}
	}

	public PlayerEntity addPlayes(PlayerEntity pe, int id) throws ServiceException {
		try {
			TeamEntity result = tRepo.findById(id);
			if (result != null) {
				PlayerEntity mResult = pRepo.findById(pe.getId());
				if (mResult == null) {
					pe.setTeams(result);
					result.setNoOfPlayes(result.getNoOfPlayes() + 1);
					tRepo.save(result);
					pRepo.save(pe);
					return pe;

				} else {
					throw new ServiceException("id already present in database");
				}
			} else {
				throw new ServiceException("track not present");
			}
		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException(e);
		}
	}

	public TeamEntity getByName(String name) throws ServiceException {
		TeamEntity mResult = tRepo.findByName(name);
		if (mResult == null) {
			throw new ServiceException("no minds for this track");
		} else {
			return mResult;

		}

	}
	public ArrayList<TeamEntity> getall() throws ServiceException {
		ArrayList<TeamEntity> mResult = (ArrayList) tRepo.findAll();
		if (mResult == null) {
			throw new ServiceException("no minds for this track");
		} else {
			return mResult;

		}

	}

	public PlayerEntity getBytrack2(String name) throws ServiceException {
		try {

			PlayerEntity mResult = pRepo.findByName(name);
			if (mResult == null) {
				throw new ServiceException("no players for this team");
			} else {
				return mResult;

			}
		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException(e);

		}

	}

	public String deletePlayer(int id) throws ServiceException {
		PlayerEntity track = null;
		try {
			track = pRepo.findById(id);
			if (track == null) {
				throw new ServiceException("No record present for this id");

			} else {
				pRepo.deleteById(id);
			}
		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException(e);

		}
		return "deleted successfully";
	}

	public String updateLact(String name, int Id) throws ServiceException {
		try {

			TeamEntity tResult = tRepo.findById(Id);
			if (tResult != null) {
				tResult.setLocation(name);
				tRepo.save(tResult);
				return " track Name updated successFully";
			} else {
				throw new ServiceException("this id not present in database");
			}

		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException(e);
		}
	}
}
