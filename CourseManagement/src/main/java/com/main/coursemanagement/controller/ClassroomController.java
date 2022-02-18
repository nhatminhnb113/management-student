package com.main.coursemanagement.controller;

import com.main.coursemanagement.entity.Classroom;
import com.main.coursemanagement.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Classroom classroom){
        classroomService.insert(classroom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Classroom classroom){
        classroomService.delete(classroom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
