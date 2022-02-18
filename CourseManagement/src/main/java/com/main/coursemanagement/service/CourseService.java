package com.main.coursemanagement.service;

import com.main.coursemanagement.entity.Course;
import com.main.coursemanagement.entity.Student;
import com.main.coursemanagement.repository.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CourseService {
    @Autowired
    CoursesRepo coursesRepo;

    public Course insert(Course course) {
        return coursesRepo.save(course);
    }

    public Course getById(int id) {
        return coursesRepo.findById(id).get();
    }

    public Set<Course> getListByStudent(int id) {
        return coursesRepo.findByStudentId(id);
    }

    public void delete(Course course) {coursesRepo.delete(course);}

}
