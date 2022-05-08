package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Votes;

public interface VotesServiceImpl {

	List<Votes> retrieveAllVotes();

	Votes addvote(Votes v);

	void deleteVotes(Integer id);

	Votes updateVotes(Votes v);

	Votes retrieveVotes(Integer id);
}
