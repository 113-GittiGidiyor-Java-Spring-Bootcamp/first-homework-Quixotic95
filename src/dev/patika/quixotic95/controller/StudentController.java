package dev.patika.quixotic95.controller;

import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Student;
import dev.patika.quixotic95.service.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService studentService = new StudentService();

    public Student findStudentById(int studentId) {
        return studentService.findById(studentId);
    }

    public List<Student> findAllStudents() {
        return studentService.findAll();
    }

    public void saveStudent(Student student) {
        studentService.save(student);
    }

    public void deleteStudentById(int studentId) {
        studentService.delete(studentId);
    }

    public void updateStudent(Student student, int studentId) {
        studentService.update(student, studentId);
    }

    public List<Course> findStudentCoursesById(int studentId) {
        return studentService.findStudentCoursesById(studentId);
    }

    public List<Course> findStudentCourses(Student student) {
        return studentService.findStudentCourses(student);
    }

}
