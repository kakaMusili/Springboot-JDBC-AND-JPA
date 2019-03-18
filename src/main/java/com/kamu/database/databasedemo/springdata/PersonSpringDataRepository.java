package com.kamu.database.databasedemo.springdata;

import com.kamu.database.databasedemo.beans.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person,Integer> {
}
