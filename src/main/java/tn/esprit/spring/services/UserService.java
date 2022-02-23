package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.reposi.UserRepository;

@Service
@Slf4j

public class UserService implements UserServiceImpl {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> retrieveAllUser() {
		List<User>user=(List<User>)userRepository.findAll();
		for (User users : user)
		{
							log.info("user :" + user);
		}
return user;
	}

	@Override
	public User addUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User retrieveUser(Integer id) {
		User user = userRepository.findById(id).orElse(null);
		System.out.println("User :" + user);
		return user;
	}
	

}
