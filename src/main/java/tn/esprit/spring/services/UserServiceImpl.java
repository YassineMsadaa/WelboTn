package tn.esprit.spring.services;

import tn.esprit.spring.entity.User;

import java.util.List;

public interface UserServiceImpl {
        public User addUser(User user);
        public void deleteUser(Long id);
        public List<User> getUsers();
        public User updateUser(User User);
        public User getUser(Long id);
}