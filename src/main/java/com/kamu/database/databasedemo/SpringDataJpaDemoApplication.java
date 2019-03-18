package com.kamu.database.databasedemo;

import com.kamu.database.databasedemo.beans.Person;
import com.kamu.database.databasedemo.jpa.PersonJpaRepository;
import com.kamu.database.databasedemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataJpaDemoApplication implements CommandLineRunner {
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		logger.info(" ***  Initial users are ******** \n {}", personJpaRepository.findAll());

		logger.info(" ***  User  {}  is ******** \n {}",10001, personJpaRepository.findById(10001));

		logger.info(" ***  inserting a new user  into the system ******** \n {}", personJpaRepository.save(new
				Person("kaka-musili","nailofi",new Date())));

		logger.info(" *** New list of  users is ******** \n {}", personJpaRepository.findAll());

		logger.info(" *** Updating user 10003  {} , ******** \n {}", personJpaRepository.findById(10003),
				personJpaRepository.save(new
						Person(10003,"Kaka-edu","Nyeri",new Date())));

	  personJpaRepository.deleteById(10001);

		logger.info(" ***  Remaining users are ******** \n {}", personJpaRepository.findAll());

		/*



        logger.info(" ***  the new list of users is now  ******** \n {}", personJdbcDao.findAll());




        logger.info(" ***  His/Her details are  ******** \n {}", personJdbcDao.findById(10003));
*/



    }
}
