package tn.esprit.spring.services;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.util.StringUtils;

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
	 public Badges store(MultipartFile file) throws IOException {
		    String FileName = StringUtils.cleanPath(file.getOriginalFilename());
		    Badges badges = new Badges(FileName, file.getContentType(), file.getBytes());
		    return badgesRepository.save(badges);
		  }
		  public Badges getFile(String id) {
		    return BadgesRepository.findById(Integer).get();
		  }
		  
		  public Stream<Badges> getAllFiles() {
		    return badgesRepository.findAll().stream();
		  }
}

		


