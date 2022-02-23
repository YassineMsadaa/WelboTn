package tn.esprit.spring.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.spring.Entity.BsUser;

import java.util.List;

public interface IBsuserService {
    public BsUser ajouterBsUser(BsUser bsuser);
    public void deleteBsUser(Long bsuserId);
    public List<BsUser> getBsUsers();
    public BsUser modifierBsUser(BsUser bsuser);
    public BsUser getBsUser(Long bsuserId);
}
