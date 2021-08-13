package dev.patika.quixotic95.controller;

import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Instructor;
import dev.patika.quixotic95.service.InstructorService;

import java.util.List;

public class InstructorController {

    private final InstructorService instructorService = new InstructorService();

    public Instructor findInstructorById(int instructorId) {
        return instructorService.findById(instructorId);
    }

    public List<Instructor> findAllInstructors() {
        return instructorService.findAll();
    }

    public void saveInstructor(Instructor instructor) {
        instructorService.save(instructor);
    }

    public void deleteInstructorById(int instructorId) {
        instructorService.deleteById(instructorId);
    }

    public void deleteInstructor(Instructor instructor) {
        instructorService.delete(instructor);
    }

    public void updateInstructor(Instructor instructor, int instructorId) {
        instructorService.update(instructor, instructorId);
    }

    public List<Course> findInstructorCoursesById(int instructorId) {
        return instructorService.findInstructorCoursesById(instructorId);
    }

    public List<Course> findInstructorCourses(Instructor instructor) {
        return instructorService.findInstructorCourses(instructor);
    }

}
