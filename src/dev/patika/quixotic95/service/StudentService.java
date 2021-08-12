package dev.patika.quixotic95.service;

import dev.patika.quixotic95.repository.CrudRepository;
import dev.patika.quixotic95.repository.StudentRepository;
import dev.patika.quixotic95.model.Course;
import dev.patika.quixotic95.model.Student;
import dev.patika.quixotic95.utility.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    private final EntityManager em = EntityManagerUtil.getEntityManager("mysqlPU");

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public void save(Student student) {
        try {
            em.getTransaction().begin();

            em.persist(student);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            em.getTransaction().begin();

            Student foundStudent = em.find(Student.class, id);
            em.remove(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void delete(Student student) {
        try {
            em.getTransaction().begin();

            Student foundStudent = find(student);
            em.remove(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void update(Student student, int id) {
        try {
            em.getTransaction().begin();

            Student foundStudent = em.find(Student.class, id);
            foundStudent.setName(student.getName());
            foundStudent.setAddress(student.getAddress());
            foundStudent.setBirthDate(student.getBirthDate());
            foundStudent.setGender(student.getGender());

            em.merge(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    public Student find(Student student) {
        return em.find(Student.class, student.getId());
    }

    @Override
    public List<Course> findStudentCoursesById(int id) {
        return findById(id).getStudentCourses();
    }

    @Override
    public List<Course> findStudentCourses(Student student) {
        return find(student).getStudentCourses();
    }
}
