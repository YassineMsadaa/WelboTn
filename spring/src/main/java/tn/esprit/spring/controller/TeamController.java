package com.jawher.pide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.jawher.pide.entities.Team;
import com.jawher.pide.service.TeamService;

@RestController
public class TeamController {
	@Autowired
	TeamService teamService;
	
	@GetMapping("/teams")
	@ResponseBody
	public List<Team> getAllTeams(){
		List<Team> list = teamService.getAllTeams();
		return list ;
		
		
	}
	
	
	@PostMapping("/AjouterTeam")
	@ResponseBody
	public Team AjouterTeam(@RequestBody Team t) {
		return teamService.AjouterTeam(t);
	}
	
	//   @ResponseBody
	 //   public void UpdateEvent(@RequestBody Event e ) {
		//	eventService.UpdateEvent(e);
		
	//	}
	@PutMapping("/modify-Team")
	@ResponseBody
	public Team modifyTeam(@RequestBody Team t) {
	return teamService.updateTeam(t);
	}
	
	@DeleteMapping("deleteTeam/{id}")
	@ResponseBody
	public void deleteTeam(@PathVariable("id") Long idTeam) {
		teamService.deleteTeamById(idTeam);
		
		
	}
	}