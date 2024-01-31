package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MyController {

    @Autowired
    private CourseServices courseServices;

    // get the course
    @CrossOrigin(origins = "*")
    @GetMapping("/courses")
    public List<Courses> getCourses(){
      return this.courseServices.getCourses();
    }

    //get the course
    @CrossOrigin(origins = "*")
    @GetMapping("/courses/{courseId}")
    public Courses getCourse( @PathVariable String courseId) {
        return this.courseServices.getCourse(Long.parseLong(courseId));
    }

    //single courses get
    @CrossOrigin(origins = "*")
    @PostMapping("/courses")
   // @PostMapping(path = "/courses", consumes = "application/json")
    public Courses addCourse(@RequestBody Courses course) {
        return this.courseServices.addCourse(course);
    }

    //update course using PUT req.
    @CrossOrigin(origins = "*")
    @PutMapping("/courses")
    public Courses updateCourse(@RequestBody Courses course){
        return this.courseServices.updateCourse(course);
    }

    //delete course using PUT req.
    @CrossOrigin(origins = "*")
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseServices.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
