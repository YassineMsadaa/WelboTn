package tn.esprit.spring.service;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.TeamCriteriaRepository;
import tn.esprit.spring.repository.TeamRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TeameService {

    private final TeamRepository teamRepository;
    private final TeamCriteriaRepository teamCriteriaRepository;

    public TeameService(TeamRepository teamRepository,
                           TeamCriteriaRepository teamCriteriaRepository) {
        this.teamRepository = teamRepository;
        this.teamCriteriaRepository = teamCriteriaRepository;
    }

    public Page<Team> getteamss(TeamPage teamPage,
                                       TeamSearchCriteria teamSearchCriteria){
        return teamCriteriaRepository.findAllWithFilters(teamPage, teamSearchCriteria);
    }

    public Team addteamss(Team team){
        return teamRepository.save(team);
    }
}
