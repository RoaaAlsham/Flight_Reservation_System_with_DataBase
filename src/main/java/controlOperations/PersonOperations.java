/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlOperations;

import MyExceptions.PersonNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import models.MyEntityController;
import models.Person;
import models.PersonGender;
import models.Role;

/**
 *
 * @author Zahera
 */
public class PersonOperations {

   
    public static void registerPerson(String firstName, String lastName, String email, String password,
           Date date,PersonGender gender, Role role)
            throws PersistenceException, RuntimeException {//if email not unique

        EntityManager em = MyEntityController.getEntityManager();
        EntityTransaction transaction = em.getTransaction();// for reusability
        try {
            transaction.begin();
            Person p = new Person(firstName, lastName, email, password, date,gender, role);
            em.persist(p);
            transaction.commit();
           
        } catch (javax.persistence.PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;

        } finally {
            em.close();

        }

    }

    public static Person getPersonByEmail(String email) throws PersonNotFoundException {
        EntityManager em = MyEntityController.getEntityManager();
        //use typedQuery so you dont need to cast the object type,the ide will knows that you expecting a person object
        TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE p.email = :email", Person.class);
        q.setParameter("email", email);
        if (q.getResultList().isEmpty()) {
            em.close();
            throw new PersonNotFoundException(email, "Person Not Found, please check your email");
        }
        Person p = q.getResultList().get(0);
        em.close();
        return p;
    }
    //continue with checking methods 23/05/2025 10.00pm

    public Person getPersonById(int id) throws PersonNotFoundException {
        EntityManager em = MyEntityController.getEntityManager();
        try {
            Person p = em.find(Person.class, id);
            if (p == null) {
                throw new PersonNotFoundException(id, "Person Not Found, please check your id");
            }
            return p;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public List<Person> getPeople() {
        EntityManager em = MyEntityController.getEntityManager();
        Query query = em.createQuery("Select p From Person p");
        List<Person> people = query.getResultList();
        em.close();

        return people;

    }

    /*
     rollback if an exception thrown because of used email
    //handle person not found exception first, then PersistenceException
     */
    public void updatePersonByID(Integer idperson,
            String firstName, String lastName, String email,
            String password, PersonGender gender, Role role) throws PersonNotFoundException, PersistenceException, RuntimeException {//is email unique
        EntityManager em = MyEntityController.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Person p = em.find(Person.class, idperson);

            if (p == null) {
                throw new PersonNotFoundException(idperson, "Person Not Found, please check your id");
            }

            p.setFirstName(firstName);
            p.setLastName(lastName);
            p.setEmail(email);
            p.setPassword(password);
            p.setGender(gender);
            p.setRole(role);
            transaction.commit();

        } catch (PersonNotFoundException | PersistenceException e) {

            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }

    }

    //لاإله إلا الله 
    public void deletePersonById(int id) {
        EntityManager em = MyEntityController.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            Person p = em.find(Person.class, id);
            if (p == null) {
                throw new PersonNotFoundException(id);
            }
            transaction.begin();
            em.remove(p);
            transaction.commit();
        } catch (PersonNotFoundException | PersistenceException e) {

            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }

    }

    public static boolean doesPasswordMatchEmail(Person person, String password) {
        EntityManager em = MyEntityController.getEntityManager();
        String personEmail= person.getEmail();
        try{
        TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE p.email = :email",Person.class);
        q.setParameter("email", personEmail);
        if( q.getResultList().isEmpty()){
            throw new PersonNotFoundException(personEmail);
            
        }
        String realPassword = q.getResultList().get(0).getPassword();   
        if (realPassword.equals(password)) {
            return true;
        }
        return false;
        }finally{
            em.close();
        }//الحمد لله//
    }
    // correct your methods according to the last chat 25/5/2025  12.54AM

   
}
