package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.IDepratmentRepository;

@Service
public class DepartementService implements IDepartementService{

    @Autowired
    IDepratmentRepository messageRepository;
}
