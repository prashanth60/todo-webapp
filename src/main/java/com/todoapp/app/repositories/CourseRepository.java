package com.todoapp.app.repositories;

import java.util.List;

import com.todoapp.app.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
    Course findByName(String name);
    List<Course> findAllByUsername(String username);
}
