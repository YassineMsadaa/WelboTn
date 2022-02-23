package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Badges;
import tn.esprit.spring.services.BadgesServiceImpl;
@RestController
@RequestMapping("/badge")
public class BadgeRestController {
	@Autowired
	BadgesServiceImpl badgesServiceImpl;

	@PostMapping("/add-Badge")
	@ResponseBody
	public Badges addBadges(@RequestBody Badges b)
	{
	Badges badges = badgesServiceImpl.addbadge(b);
	return badges;
	}
	@GetMapping("/retrieve-All-Badges")
	@ResponseBody
	public List<Badges> getBadges() {
		List<Badges> listBadges = badgesServiceImpl.retrieveAllBadges();
		return listBadges;
		}
}
	


