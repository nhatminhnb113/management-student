package com.main.coursemanagement.repository;
import com.main.coursemanagement.entity.Classroom;
import com.main.coursemanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepo extends JpaRepository<Student, Integer> {
    List<Student> findStudentByClassrooms(Classroom classroom);
}
