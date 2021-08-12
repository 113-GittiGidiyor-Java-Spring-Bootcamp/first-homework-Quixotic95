package dev.patika.quixotic95.service;

import dev.patika.quixotic95.repository.CourseRepository;
import dev.patika.quixotic95.repository.CrudRepository;
import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Instructor;
import dev.patika.quixotic95.model.Student;
import dev.patika.quixotic95.utility.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course>, CourseRepository {

    final EntityManager em = EntityManagerUtil.getEntityManager("mysqlPU");

    @Override
    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        return em.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public void save(Course course) {
        try {
            em.getTransaction().begin();

            em.persist(course);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void delete(int id) {
        try {
            em.getTransaction().begin();

            Course foundCourse = em.find(Course.class, id);
            em.remove(foundCourse);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void update(Course course, int id) {
        try {
            em.getTransaction().begin();

            Course foundCourse = em.find(Course.class, id);
            foundCourse.setCourseName(course.getCourseName());
            foundCourse.setCourseCode(course.getCourseCode());
            foundCourse.setCreditScore(course.getCreditScore());

            em.merge(foundCourse);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    public Course find(Course course) {
        return em.find(Course.class, course.getId());
    }

    @Override
    public List<Student> findCourseStudents(Course course) {
        return find(course).getCourseStudents();
    }

    @Override
    public Instructor findCourseInstructor(Course course) {
        return find(course).getCourseInstructor();
    }
}
