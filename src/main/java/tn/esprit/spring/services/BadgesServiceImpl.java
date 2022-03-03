package tn.esprit.spring.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Badges;

public interface BadgesServiceImpl {

	List<Badges> retrieveAllBadges();
	
	Badges addbadge(Badges b);

	void deleteBadges(Integer id);

	Badges updateBadges(Badges b);

	Badges retrieveBadges(Integer id);
	
	Badges getFile(Long id);
	
	Stream<Badges> loadAll();
	
	Badges store(MultipartFile file)throws IOException ;
}

	


