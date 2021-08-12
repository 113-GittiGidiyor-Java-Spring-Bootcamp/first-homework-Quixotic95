package dev.patika.quixotic95.repository;

import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Instructor;
import dev.patika.quixotic95.model.Student;

import java.util.List;

public interface CourseRepository {
    List<Student> findCourseStudentsById(int id);
    List<Student> findCourseStudents(Course object);
    Instructor findCourseInstructorById(int id);
    Instructor findCourseInstructor(Course object);
}
