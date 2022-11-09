package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {


    @Autowired
    private CourseServices courseService;

    @GetMapping("/home")
    public String home() {
        return "Welcome,This is Home Page";
    }

    //get Courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    //Single Get Course by ID
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //Add Courses
    @PostMapping("/courses")
    public Course AddCourse(@RequestBody Course course) {

        return this.courseService.addCourse(course);
    }

    //Update Course using PUT request
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {

        return this.courseService.updateCourse(course);
    }

    //delete Course by ID
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
