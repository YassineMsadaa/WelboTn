package com.jawher.pide.service;

import java.util.List;

import com.jawher.pide.entities.Competition;

public interface CompetitionService {
	Competition AjouterCompetition(Competition c);
	Competition updateCompetition(Competition c);
	 void deleteCompetition(Competition c);
	 void deleteCompetitionById(Long id);
	 Competition getCompetition(Long id);
	 List<Competition> getAllCompetitions();


}
