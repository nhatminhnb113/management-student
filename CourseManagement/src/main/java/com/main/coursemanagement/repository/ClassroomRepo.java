package com.main.coursemanagement.repository;

import com.main.coursemanagement.entity.Classroom;
import com.main.coursemanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ClassroomRepo extends JpaRepository<Classroom, Integer> {

    List<Classroom> findClassroomsByCourse(Course course);

    @Query(value = "select a.id from (select * from  classroom where course_id=?1) as a inner",nativeQuery = true)
    int findClassroomByStudentCourse(int sid, int cid);

    @Query(value = "select count student_id from student_classroom where classroom_id = ?1", nativeQuery = true)
    int studentInClassroom(int id);

    @Query(value = "select * from classroom where course_id is null", nativeQuery = true)
    List<Classroom> findByNonCourse();

}
