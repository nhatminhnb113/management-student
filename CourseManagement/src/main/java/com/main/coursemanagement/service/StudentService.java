package com.main.coursemanagement.service;

import com.main.coursemanagement.entity.Classroom;
import com.main.coursemanagement.entity.Course;
import com.main.coursemanagement.entity.Student;
import com.main.coursemanagement.repository.ClassroomRepo;
import com.main.coursemanagement.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentsRepo studentsRepo;
    @Autowired
    ClassroomRepo classroomRepo;

    public Student insert(Student student) {
        return studentsRepo.save(student);
    }

    public List<Student> listByClassroom (Classroom classroom) {
        return studentsRepo.findStudentByClassrooms(classroom);
    }

    public void register(Student student, Course course) {
        List<Classroom> classrooms = classroomRepo.findClassroomsByCourse(course);
        List<Classroom> classrooms2 = classroomRepo.findByNonCourse();
        if (classrooms.size() > 0) {
            for (int i = 0; i < classrooms.size(); i++) {
                if (classroomRepo.studentInClassroom(classrooms.get(i).getId()) < 30) {
                    student.getClassrooms().add(classrooms.get(i));
                    student.getCourses().add(course);
                    classrooms.get(i).setCourse(course);
                    studentsRepo.save(student);
                    classroomRepo.save(classrooms.get(i));
                    break;
                }
            }
        } else if (classrooms2.size() > 0) {
            student.getClassrooms().add(classrooms2.get(0));
            student.getCourses().add(course);
            classrooms2.get(0).setCourse(course);
            studentsRepo.save(student);
            classroomRepo.save(classrooms2.get(0));
        }

    }

    public Student cancelRegistrationById(Student student, Course course) {
        student.getCourses().remove(course);
        student.getClassrooms().remove(classroomRepo.findClassroomsByCourse(course));
        return studentsRepo.save(student);
    }

    public void delete(Student student) {
        studentsRepo.delete(student);
    }

    public Student getbyId(int id) {
        return studentsRepo.findById(id).get();
    }
}
