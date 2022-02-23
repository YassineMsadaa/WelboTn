package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Repository.NewsFeedPostRepository;
import tn.esprit.spring.Repository.BsUserRepository;

import java.util.List;

@Service
public class BsuserService implements IBsuserService{
    @Autowired
    BsUserRepository bsuserRepository;


    @Override
    public BsUser ajouterBsUser(BsUser bsuser) {
        bsuserRepository.save(bsuser);
        return bsuser;
    }



    @Override
    public void deleteBsUser(Long bsuserId) {
        bsuserRepository.deleteById(bsuserId);

    }

    @Override
    public List<BsUser> getBsUsers() {

        return (List<BsUser>) bsuserRepository.findAll();
    }

    @Override
    public BsUser modifierBsUser( BsUser bsuser) {
        bsuserRepository.save(bsuser);
        return bsuser;
    }

    @Override
    public BsUser getBsUser(Long bsuserId) {
        return bsuserRepository.findById(bsuserId).get();
    }

}
