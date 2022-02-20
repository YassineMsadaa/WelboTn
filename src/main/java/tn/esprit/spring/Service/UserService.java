package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.IUserRepository;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;
}
