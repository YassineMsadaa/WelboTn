package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Badges;

public interface BadgesServiceImpl {

	List<Badges> retrieveAllBadges();
	
	Badges addbadge(Badges b);

	void deleteBadges(Integer id);

	Badges updateBadges(Badges b);

	Badges retrieveBadges(Integer id);

	

}
