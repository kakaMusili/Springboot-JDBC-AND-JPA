package com.kamu.database.databasedemo.jpa;


import com.kamu.database.databasedemo.beans.Person;
import com.kamu.database.databasedemo.jdbc.PersonJdbcDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//repository
@Repository
//transaction
@Transactional
public class PersonJpaRepository {

    //database connection
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id)
    {
        return entityManager.find(Person.class, id);
    }


    public Person insertPerson(Person person) {
        return entityManager.merge(person);
    }


    public Person updatePerson(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person=findById(id);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
      //  return entityManager.find()
        TypedQuery<Person> personTypedQuery=entityManager.createNamedQuery("fetch-all-person", Person.class);
         return personTypedQuery.getResultList();


    }

}
