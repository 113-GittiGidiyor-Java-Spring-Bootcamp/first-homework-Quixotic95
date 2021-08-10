package dev.patika.Quixotic95.repository;

import dev.patika.Quixotic95.model.Course;
import dev.patika.Quixotic95.model.Instructor;
import dev.patika.Quixotic95.model.Student;

import java.util.List;

public interface CourseRepository {
    List<Student> findCourseStudents(Course object);
    Instructor findCourseInstructor(Course object);
}
