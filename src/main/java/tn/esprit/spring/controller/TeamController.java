package tn.esprit.spring.controller;

import tn.esprit.spring.entity.Team;
import tn.esprit.spring.entity.TeamPage;
import tn.esprit.spring.entity.TeamSearchCriteria;
import tn.esprit.spring.service.TeameService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeameService teameService;

    public TeamController(TeameService teameService) {
        this.teameService = teameService;
    }

    @GetMapping
    public ResponseEntity<Page<Team>> getEmployees(TeamPage teamPage,
                                                       TeamSearchCriteria teamSearchCriteria){
        return new ResponseEntity<>(teameService.getteamss(teamPage, teamSearchCriteria),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Team> addEmployee(@RequestBody Team team){
        return new ResponseEntity<>(teameService.addteamss(team), HttpStatus.OK);
    }
}
