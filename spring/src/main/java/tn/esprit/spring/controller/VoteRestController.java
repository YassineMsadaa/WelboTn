package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Votes;
import tn.esprit.spring.services.VotesServiceImpl;
@RestController
@RequestMapping("/votes")
public class VoteRestController {
@Autowired
VotesServiceImpl votesServiceImpl;

@PostMapping("/add-Vote")
@ResponseBody
public Votes addVote(@RequestBody Votes v)
{
Votes votes = votesServiceImpl.addvote(v);
return votes;
}

@DeleteMapping("/remove-Votes/{id}")
@ResponseBody
public void removeVotes(@PathVariable("id")Integer Id)
{
votesServiceImpl.deleteVotes(Id);
}

@GetMapping("/retrieve-All-votes")
@ResponseBody
public List<Votes> getVotes() {
	List<Votes> listVotes = votesServiceImpl.retrieveAllVotes();
	return listVotes;
	}
}

