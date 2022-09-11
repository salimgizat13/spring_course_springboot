package com.gizatullin.spring.springboot.spring_course_springboot.service;

import com.gizatullin.spring.springboot.spring_course_springboot.dao.UserRepository;
import com.gizatullin.spring.springboot.spring_course_springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User updateUser (long id) {
       User updatedUser = getUserById(id);
        userRepository.save(updatedUser);
       return updatedUser;
    }

    public void deleteUser (long id) {
        userRepository.delete(getUserById(id));
    }

    public User getUserById (long id) {
        return userRepository.findById(id).orElse(null);  // или другой метод??
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}

//    @Override
//    public User updateUser(User user, long id) {
//        User updatedUser = getUserById(id);
//        updatedUser.setUsername(user.getUsername());
//        updatedUser.setEmail(user.getEmail());
//        updatedUser.setPassword(user.getPassword());
//        return em.merge(updatedUser);
//    }
//
//    @Override
//    public void deleteUser(long id) {
//        em.remove(getUserById(id));
//    }
