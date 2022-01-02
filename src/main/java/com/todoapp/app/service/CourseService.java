package com.todoapp.app.service;

import java.util.List;

import com.todoapp.app.entity.Course;
import com.todoapp.app.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    // POST
    public Course saveCourse(Course course){
        System.out.println(course.toString());
        return courseRepository.save(course);
    }

    //Optional!
    public List<Course> saveCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    //GEt
    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    public Course getCourseById(int id){
        return courseRepository.findById(id)
                .orElse(null);
    }

    public Course getCourseByName(String name){
        return courseRepository.findByName(name);
    }

    public List<Course> getCoursesForUser(String username){
        return courseRepository.findAllByUsername(username);
    }

    // PUT
    public Course udpdateCourse(Course course){
        System.out.println("updates");
        Course courseToUpdate = this.getCourseById(course.getId());

        courseToUpdate.setName(course.getName());
        courseToUpdate.setDescription(course.getDescription());
        courseToUpdate.setStatus(course.getStatus());

        return courseRepository.save(courseToUpdate);
    }

    // DELETE
    public String deleteCourse(int id){
        courseRepository.deleteById(id);
        return id + " id -> course removed/completed";
    }
    
}
