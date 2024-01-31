package com.springrest.springrest.services;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.entities.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceimpl implements CourseServices{

    @Autowired
    private CourseDao courseDao;

//    List<Courses> list;

    public CourseServiceimpl(){
//        list= new ArrayList<>();
//        list.add(new Courses(124,"Java course","This is full video"));
//        list.add(new Courses(125,"Spring Boot course","This is full video Spring API"));
    }


    @Override
    public List<Courses> getCourses() {
        return courseDao.findAll();  // return list;
    }

    @Override
    public Courses getCourse(long courseId) {
//        Courses c =null;
//        for(Courses courses: list){
//            if (courses.getId()==courseId){
//                c=courses;
//                break;
//            }
//        }

        return courseDao.getOne(courseId);
    }

    @Override
    public Courses addCourse(Courses course) {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Courses updateCourse(Courses course) {
//        list.forEach( e-> {
//            if(e.getId() == course.getId()){
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
        this.courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long parsesLong) {
//        list= this.list.stream().filter(e -> e.getId()!= parsesLong).collect(Collectors.toList());
        Courses entity = courseDao.getOne(parsesLong);
        courseDao.delete(entity);
    }


}
