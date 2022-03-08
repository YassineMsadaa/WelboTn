package tn.esprit.spring.services;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Badges;
import tn.esprit.spring.reposi.BadgesRepository; 
@Service
@Slf4j
public class BadgesService implements BadgesServiceImpl {	
	@Autowired
	BadgesRepository badgesRepository;

	@Override
	public List<Badges> retrieveAllBadges() {		
	List<Badges>badges=(List<Badges>)badgesRepository.findAll();
		for (Badges badge : badges)
		{
							log.info("badges :" + badges);
		}
return badges;
	}

	@Override
	public Badges addbadge(Badges b) {
		return badgesRepository.save(b);
    }

	@Override
	public void deleteBadges(Integer id) {
		badgesRepository.deleteById(id);
		
	}

	@Override
	public Badges updateBadges(Badges b) {
		return badgesRepository.save(b);
	}

	@Override
	    public Badges retrieveBadges(Integer id) {
		Badges badge = badgesRepository.findById(id).orElse(null);
		System.out.println("Badges :" + badge);
		return badge;
	}
	@Override
		 public Badges getFile(Integer id) {
		 return badgesRepository.findById(id).get();
		 }
		 @Override
		public Stream<Badges> getAllFiles() {
		return  badgesRepository.findAll().stream();
		}
		@Override
	public Badges store(MultipartFile file) throws IOException {
	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Badges badges = new Badges(file.getContentType(), file.getBytes(), fileName);
				   return badgesRepository.save(badges);
				  }
		
		@Override
		public List getAllBadgesBynom() {
			return badgesRepository.getAllBadgesBynom();
		
}
}

		


