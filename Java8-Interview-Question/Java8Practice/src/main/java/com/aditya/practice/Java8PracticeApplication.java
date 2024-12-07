package com.aditya.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aditya.practice.question.Question;

@SpringBootApplication
public class Java8PracticeApplication implements CommandLineRunner{

	@Autowired
	private Question question;
	
	public static void main(String[] args) {
		SpringApplication.run(Java8PracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * System.out.println(question.studentsWithFirstNameStartsWith_A());
		 * System.out.println(question.groupStudentsBasedOnDepartment());
		 * System.out.println(question.totalStudentCount());
		 * System.out.println(question.maxAgeStudent());
		 * System.out.println(question.getAllDepartMents());
		 * System.out.println(question.countByDept());
		 * System.out.println(question.studentsAgeLessthan_30());
		 * System.out.println(question.getStudentWithRankBetween_50_and_100());
		 * System.out.println(question.getAverageAgeOnGender());
		 * System.out.println(question.getDeptWitMaxStudent());
		 * System.out.println(question.studentLiveinDelhi());
		 * System.out.println(question.getAverageRankInAllDept());
		 * System.out.println(question.studentSortedByRank());
		 */
		System.out.println(question.get2ndRankStudent());

	}

}
