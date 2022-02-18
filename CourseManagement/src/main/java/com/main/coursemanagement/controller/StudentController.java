package com.main.coursemanagement.controller;

import com.main.coursemanagement.entity.Student;
import com.main.coursemanagement.service.CourseService;
import com.main.coursemanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/register/{sid}/{cid}")
    public ResponseEntity<?> register(@PathVariable("sid") int sid, @PathVariable("cid") int cid) {
        studentService.register(studentService.getbyId(sid), courseService.getById(cid));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/cancelRegistration/{sid}/{cid}")
    public ResponseEntity<?> cancelRegistration(@PathVariable("sid") int sid, @PathVariable("cid") int cid) {
        studentService.cancelRegistrationById(studentService.getbyId(sid), courseService.getById(cid));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.insert(student), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Student student) {
        studentService.delete(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Student student){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
