package com.jawher.pide.service;

import java.util.List;

import com.jawher.pide.entities.Team;

public interface TeamService {
	Team AjouterTeam(Team t);
	Team updateTeam(Team t);
	 void deleteTeam(Team t);
	 void deleteTeamById(Long id);
	 Team getTeam(Long id);
	 List<Team> getAllTeams();
	

}
