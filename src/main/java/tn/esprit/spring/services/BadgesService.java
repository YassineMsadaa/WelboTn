package tn.esprit.spring.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	

}

		


