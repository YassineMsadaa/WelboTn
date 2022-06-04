package com.jawher.pide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawher.pide.entities.Competition;
import com.jawher.pide.entities.Team;
import com.jawher.pide.repos.TeamRepository;
@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamRepository teamRepository ;
	@Override
	public Team AjouterTeam(Team t) {
		teamRepository.save(t);
		return t;
	}

	@Override
	public Team updateTeam(Team t) {
		
		return teamRepository.save(t);
	}

	@Override
	public void deleteTeam(Team t) {
		teamRepository.delete(t);
	}

	@Override
	public void deleteTeamById(Long id) {
		teamRepository.deleteById(id);
		
	}

	@Override
	public Team getTeam(Long id) {
		
		return teamRepository.findById(id).get();
	}

	@Override
	public List<Team> getAllTeams() {
		return  (List<Team>) teamRepository.findAll();
	}

}
