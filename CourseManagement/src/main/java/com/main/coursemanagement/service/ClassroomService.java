package com.main.coursemanagement.service;

import com.main.coursemanagement.entity.Classroom;
import com.main.coursemanagement.repository.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    @Autowired
    ClassroomRepo classroomRepo;

    public Classroom insert(Classroom classroom){
        return classroomRepo.save(classroom);
    }
    public void delete(Classroom classroom){
        classroomRepo.delete(classroom);
    }

}
