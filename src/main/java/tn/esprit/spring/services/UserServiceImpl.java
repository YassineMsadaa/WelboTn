package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface UserServiceImpl {

	List<User> retrieveAllUser();

	User addUser(User u);

	void deleteUser(Integer id);

	User updateUser(User u);

	User retrieveUser(Integer id);

}
