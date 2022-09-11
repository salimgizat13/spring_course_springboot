package com.gizatullin.spring.springboot.spring_course_springboot.service;

import com.gizatullin.spring.springboot.spring_course_springboot.model.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public User updateUser (long id);

    public void deleteUser (long id);

    public User getUserById (long id);

    public List<User> getUsers();
}
