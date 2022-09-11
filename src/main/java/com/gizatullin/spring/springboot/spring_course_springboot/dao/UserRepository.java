package com.gizatullin.spring.springboot.spring_course_springboot.dao;

import com.gizatullin.spring.springboot.spring_course_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    User getUserById(long id);
    void deleteById(Long id);
}
