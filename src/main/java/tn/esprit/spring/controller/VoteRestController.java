package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Votes;
import tn.esprit.spring.services.VotesServiceImpl;

@RestController
@RequestMapping("/Votes")
public class VoteRestController {
@Autowired
VotesServiceImpl votesServiceImpl;

@PostMapping("/add-vote")
@ResponseBody
public Votes addVotes(@RequestBody Votes v)
{
Votes votes = votesServiceImpl.addVotes(v);
return votes;
}
@GetMapping("/retrieve-All-Votes")
@ResponseBody
public List<Votes> getVotes() {
	List<Votes> listVotes = votesServiceImpl.retrieveAllVotes();
	return listVotes;
	}
}

