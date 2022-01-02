package com.todoapp.app.controller;

import java.util.List;

import com.todoapp.app.entity.Course;
import com.todoapp.app.service.CourseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    
    @GetMapping()
    public List<Course> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/course/{id}")
    public Course findCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/course/{name}")
    public Course findCourseByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }

    @GetMapping("/listUsername/{username}")
    public List<Course> findCoursesByUsername(@PathVariable String username) {
        return courseService.getCoursesForUser(username);
    }

    @PostMapping()
    public Course addCourse(@RequestBody Course course) {
        logger.info("Course object {}", course);
        return courseService.saveCourse(course);
    }

    @PutMapping()
    public Course updateCourse(@RequestBody Course course){
        System.out.println("UPDATED");
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }

}
