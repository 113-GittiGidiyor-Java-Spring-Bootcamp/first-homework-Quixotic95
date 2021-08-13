package dev.patika.quixotic95.service;

import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Instructor;
import dev.patika.quixotic95.repository.CrudRepository;
import dev.patika.quixotic95.repository.InstructorRepository;
import dev.patika.quixotic95.utility.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorService implements CrudRepository<Instructor>, InstructorRepository {

    private final EntityManager em = EntityManagerUtil.getEntityManager("mysqlPU");

    @Override
    public Instructor findById(int instructorId) {
        return em.find(Instructor.class, instructorId);
    }

    @Override
    public List<Instructor> findAll() {
        return em.createQuery("from Instructor", Instructor.class).getResultList();
    }

    @Override
    public void save(Instructor instructor) {
        try {
            em.getTransaction().begin();

            em.persist(instructor);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void deleteById(int instructorId) {
        try {
            em.getTransaction().begin();

            Instructor foundInstructor = findById(instructorId);
            em.remove(foundInstructor);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void delete(Instructor instructor) {
        try {
            em.getTransaction().begin();

            Instructor foundInstructor = find(instructor);
            em.remove(foundInstructor);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void update(Instructor instructor, int instructorId) {
        try {
            em.getTransaction().begin();

            Instructor foundInstructor = findById(instructorId);
            foundInstructor.setName(instructor.getName());
            foundInstructor.setAddress(instructor.getAddress());
            foundInstructor.setPhoneNumber(instructor.getPhoneNumber());

            em.merge(foundInstructor);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    public Instructor find(Instructor instructor) {
        return em.find(Instructor.class, instructor.getId());
    }

    @Override
    public List<Course> findInstructorCoursesById(int instructorId) {
        return findById(instructorId).getInstructorCourses();
    }

    @Override
    public List<Course> findInstructorCourses(Instructor instructor) {
        return find(instructor).getInstructorCourses();
    }

}
