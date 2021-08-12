package dev.patika.quixotic95.controller;

import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Instructor;
import dev.patika.quixotic95.model.Student;
import dev.patika.quixotic95.service.CourseService;

import java.util.List;

public class CourseController {

    private final CourseService courseService = new CourseService();

    public Course findCourseById(int courseId) {
        return courseService.findById(courseId);
    }

    public List<Course> findAllCourses() {
        return courseService.findAll();
    }

    public void saveCourse(Course course) {
        courseService.save(course);
    }

    public void deleteCourseById(int courseId) {
        courseService.deleteById(courseId);
    }

    public void deleteCourse(Course course) {
        courseService.delete(course);
    }

    public void updateCourse(Course course, int courseId) {
        courseService.update(course, courseId);
    }

    public List<Student> findCourseStudentsById(int courseId) {
        return courseService.findCourseStudentsById(courseId);
    }

    public List<Student> findCourseStudents(Course course) {
        return courseService.findCourseStudents(course);
    }

    public Instructor findCourseInstructorById(int courseId) {
        return courseService.findCourseInstructorById(courseId);
    }

    public Instructor findCourseInstructor(Course course) {
        return courseService.findCourseInstructor(course);
    }

}
