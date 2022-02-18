package com.main.coursemanagement.repository;
import com.main.coursemanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<Student, Integer> {
}
