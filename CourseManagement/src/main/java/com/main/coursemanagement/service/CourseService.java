package com.main.coursemanagement.service;

import com.main.coursemanagement.entity.Course;
import com.main.coursemanagement.entity.Student;
import com.main.coursemanagement.repository.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Course> getListByStudent(Student student) {
        return coursesRepo.findCourseByStudents(student);
    }

    public void delete(Course course) {coursesRepo.delete(course);}

}
