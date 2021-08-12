package dev.patika.Quixotic95.client;

import dev.patika.Quixotic95.model.*;
import dev.patika.Quixotic95.utility.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;

public class ApiTest {

    public static void main(String[] args) {
        saveTestData();
    }


    private static void saveTestData() {

        Student student1 = new Student("Edwin Bailey", LocalDate.of(1991, Month.MAY, 5), "Ottawa, Canada", 'M');
        Student student2 = new Student("Henry Elliott", LocalDate.of(2002, Month.AUGUST, 19), "San Juan, Puerto Rico", 'M');
        Student student3 = new Student("Brad Johnson", LocalDate.of(1998, Month.AUGUST, 4), "Yokohama, Japan", 'M');
        Student student4 = new Student("Ada Richards", LocalDate.of(1995, Month.DECEMBER, 13), "Yerevan, Armenia", 'F');
        Student student5 = new Student("Olivia Parker", LocalDate.of(2001, Month.APRIL, 22), "Gaborone, Botswana", 'F');

        Course course1 = new Course("Turkish Language - 1", "TDL1001", 2);
        Course course2 = new Course("Ataturk’s Principles and Turkish Revolution History", "ATA1001", 3);
        Course course3 = new Course("Basic Art Education", "MTP1001", 4);
        Course course4 = new Course("Fashion Picture and Illustration", "MTP1005", 5);

        Instructor instructor1 = new PermanentInstructor("Maddie Johnston", "Kuwait City, Kuwait", "356-1742-16", 5500);
        Instructor instructor2 = new VisitingResearcher("William Ross", "Kigali, Rwanda", "820-9900-18", 200);
        Instructor instructor3 = new PermanentInstructor("Belinda Riley", "Bordeaux, France", "207-2627-45", 6000);

        course1.getCourseStudents().add(student1);
        course1.getCourseStudents().add(student3);
        course1.getCourseStudents().add(student5);

        course2.getCourseStudents().add(student1);
        course2.getCourseStudents().add(student3);

        course3.getCourseStudents().add(student4);
        course3.getCourseStudents().add(student5);

        course4.getCourseStudents().add(student5);

        course1.setCourseInstructor(instructor1);
        course2.setCourseInstructor(instructor3);
        course3.setCourseInstructor(instructor3);
        course4.setCourseInstructor(instructor2);

        EntityManager em = EntityManagerUtil.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);

            em.persist(instructor1);
            em.persist(instructor2);
            em.persist(instructor3);

            em.getTransaction().commit();

            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

}
