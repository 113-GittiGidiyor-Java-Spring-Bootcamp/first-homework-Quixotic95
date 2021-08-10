package dev.patika.Quixotic95.repository;

import dev.patika.Quixotic95.model.Course;
import dev.patika.Quixotic95.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Course> findStudentCourses(Student object);
}
