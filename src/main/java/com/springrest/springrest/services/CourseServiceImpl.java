package com.springrest.springrest.services;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseServices {

    @Autowired
    private CourseDao courseDao;
    List<Course> list;


    public CourseServiceImpl() {
       /* list = new ArrayList<>();
        list.add(new Course(111, "English", "English is very funny language"));
        list.add(new Course(222, "Hindi", "Hindi is very Nice language"));*/
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long CourseID) {

     /*   Course c = null;
        for (Course course : list) {
            if (course.getId() == CourseID) {
                c = course;
                break;
            }
        }
      */
        return courseDao.getOne(CourseID);


    }

    @Override
    public Course addCourse(Course course) {
        //list.add(course);

        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
      /*  list.forEach(e -> {
            if (e.getId() == course.getId()) {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });*/
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long CourseID) {
       // list = this.list.stream().filter(e -> e.getId() != CourseID).collect(Collectors.toList());
        Course entity = courseDao.getOne(CourseID);
        courseDao.delete(entity);
    }


}
