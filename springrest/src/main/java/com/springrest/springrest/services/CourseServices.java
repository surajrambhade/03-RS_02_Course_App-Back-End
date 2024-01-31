package com.springrest.springrest.services;

import com.springrest.springrest.entities.Courses;

import java.util.List;

public interface CourseServices {

    public List<Courses> getCourses();

    public Courses getCourse(long courseId);

    public Courses addCourse(Courses course);

    public Courses updateCourse(Courses course);

    public void deleteCourse(long parsesLong);


}
