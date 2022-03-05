package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.User;

import java.util.List;

public interface IUserService {
        public User addUser(User user);
        public void deleteUser(Long id);
        public List<User> getUsers();
        public User updateUser(User User);
        public User getUser(Long id);
}

