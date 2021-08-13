package dev.patika.quixotic95.repository;

import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Student;

import java.util.List;

public interface StudentRepository {

    List<Course> findStudentCoursesById(int id);

    List<Course> findStudentCourses(Student object);

}
