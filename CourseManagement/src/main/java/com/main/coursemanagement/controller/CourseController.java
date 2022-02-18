package com.main.coursemanagement.controller;

import com.main.coursemanagement.entity.Course;
import com.main.coursemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/listByStudent/{id}")
    public ResponseEntity<?> getListByStudentId(@PathVariable("id") int id) {
        return new ResponseEntity<>(courseService.getListByStudent(id),HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Course course){
        courseService.delete(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Course course){
        return new ResponseEntity<>(courseService.insert(course),HttpStatus.OK);
    }

}
