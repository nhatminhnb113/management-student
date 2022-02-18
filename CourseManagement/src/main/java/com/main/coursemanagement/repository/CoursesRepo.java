package com.main.coursemanagement.repository;

import com.main.coursemanagement.entity.Course;
import com.main.coursemanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CoursesRepo extends JpaRepository<Course, Integer> {
    @Query(value = "select * from course " +
            "INNER JOIN student_course ON course.id = student_course.course_id  " +
            "WHERE student_course.student_id = ?1",nativeQuery = true)
    Set<Course> findByStudentId(int id);

    List<Course> findCourseByStudents(Student student);
}
