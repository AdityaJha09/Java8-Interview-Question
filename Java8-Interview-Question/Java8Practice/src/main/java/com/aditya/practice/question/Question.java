package com.aditya.practice.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aditya.practice.dto.Student;

@Service
public class Question {

	private List<Student> getStudentList() {
		List<Student> list = Arrays.asList(
				new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
		return list;
	}

	/* 1- Find list of students whose first name starts with alphabet A */

	public List<Student> studentsWithFirstNameStartsWith_A() {
		List<Student> list = getStudentList();
		return list.stream().filter(student -> student.getFirstName().startsWith("A")).collect(Collectors.toList());
	}

	/* 2- Group The Student By Department Names */

	public Map<String, List<Student>> groupStudentsBasedOnDepartment() {
		List<Student> list = getStudentList();
		return list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
	}

	/* 3- Find the total count of student using stream */

	public Long totalStudentCount() {
		return getStudentList().stream().count();
	}

	/* 4- Find the max age of student */

	public Student maxAgeStudent() {
		List<Student> list = getStudentList();
		return list.stream().max(Comparator.comparingInt(Student::getAge)).get();
	}

	/* 5- Find all departments names */

	public List<String> getAllDepartMents() {
		List<Student> list = getStudentList();
		return list.stream().map(stu -> stu.getDepartmantName()).distinct().collect(Collectors.toList());
	}

	/* 6- Find the count of student in each department */

	public Map<String, Long> countByDept() {
		List<Student> list = getStudentList();
		return list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
	}
	/* 7- Find the list of students whose age is less than 30 */

	public List<Student> studentsAgeLessthan_30() {
		List<Student> list = getStudentList();
		return list.stream().filter(it -> it.getAge() < 30).collect(Collectors.toList());
	}

	/* 8- Find the list of students whose rank is in between 50 and 100 */

	public List<Student> getStudentWithRankBetween_50_and_100() {
		List<Student> list = getStudentList();
		return list.stream().filter(s -> s.getRank() > 50 && s.getRank() < 100).collect(Collectors.toList());
	}

	/* 9- Find the average age of male and female students */
	public Map<String, Double> getAverageAgeOnGender() {
		List<Student> list = getStudentList();
		return list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge)));
	}

	/* 10- Find the department who is having maximum number of students */

	public String getDeptWitMaxStudent() {
		List<Student> list = getStudentList();
		return list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
				.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
	}

	/* 11- Find the Students who stays in Delhi and sort them by their names */

	public List<Student> studentLiveinDelhi() {
		List<Student> list = getStudentList();
		return list.stream().filter(st -> st.getCity().equalsIgnoreCase("Delhi"))
				.sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
	}

	/* 12- Find the average rank in all departments */
	public Map<String, Double> getAverageRankInAllDept() {
		List<Student> list = getStudentList();
		return list.stream().collect(
				Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingDouble(Student::getRank)));

	}

	/* 14- Find the list of students and sort them by their rank */

	public List<Student> studentSortedByRank() {
		List<Student> list = getStudentList();
		return list.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
	}

	/* 15- Find the student who has second rank */
	public Student get2ndRankStudent() {
		return getStudentList().stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
	}
}
