package dev.patika.quixotic95.repository;

import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Instructor;

import java.util.List;

public interface InstructorRepository {

    List<Course> findInstructorCoursesById(int id);

    List<Course> findInstructorCourses(Instructor object);

}
