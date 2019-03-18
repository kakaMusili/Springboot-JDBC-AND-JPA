package com.kamu.database.databasedemo;

import com.kamu.database.databasedemo.beans.Person;
import com.kamu.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("-------- All users in the systema are ------>  \n {}", personJdbcDao.findAll());
		logger.info(" ***  User  {}  is ******** \n {}",10001, personJdbcDao.findById(10001));
		logger.info(" ***  User  {}  is deleted ******** \n {}",10001, personJdbcDao.deleteById(10001));
		logger.info(" ***  remaining users are ******** \n {}", personJdbcDao.findAll());
		logger.info(" ***  insertig a new user  into the system ******** \n {}", personJdbcDao.insertPerson(new
                Person(10004,"kaka-musili","malindi",new Date())));

        logger.info(" ***  the new list of users is now  ******** \n {}", personJdbcDao.findAll());


        logger.info(" *** updating user 10003  {} , ******** \n {}", personJdbcDao.findById(10003),
                personJdbcDao.updatePerson(new
                        Person(10003,"Kaka-edu","Nyeri",new Date())));

        logger.info(" ***  His/Her details are  ******** \n {}", personJdbcDao.findById(10003));




    }
}
