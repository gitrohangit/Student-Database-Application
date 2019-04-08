package studentdatabaseapp;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance;
	private int coseOfCourse = 600;
	private static int id = 1000;

	Scanner in = new Scanner(System.in);

	public Student() {

		System.out.println("Enter student's First Name:");
		this.firstName = in.nextLine();

		System.out.println("Enter student's Last Name:");
		this.lastName = in.nextLine();

		System.out.println("Enter student's class year:\n1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior ");

		// As nextInt does not read \n character, it messes with next nextline();
		this.gradeYear = Integer.parseInt(in.nextLine());
		setStudentId();
	}

	// Generate ID
	private void setStudentId() {
		// studentID=Grade level + ID
		id++;
		this.studentID = gradeYear + "" + id;
	}

	// Enroll in courses
	public void enroll() {
		do {
			System.out.println("Enter a courses to Enroll:\nHistory 101\nMAths 101\nEnglish 101\nPress 'Q' to Quit ");
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses += "\n " + course;
				tuitionBalance += coseOfCourse;
			} else {
				break;
			}
		} while (true);

		System.out.println("Enrolled In: " + courses);
		// System.out.println("Tuition Balance: " + tuitionBalance);
	}

	// View Balance
	public void viewBalance() {
		System.out.println("Your balance is: Rs" + tuitionBalance);
	}

	// do payment
	public void payTuition() {
		if(tuitionBalance != 0) {
			viewBalance();
			System.out.println("Enter your payment:");
			int payment = in.nextInt();
			try {
				if (payment >= tuitionBalance) {
					throw new ArithmeticException();
				}
				else {
					tuitionBalance -= payment;
					System.out.println("Thank you for your payment of: Rs" + payment);
					viewBalance();
				}
			} catch (ArithmeticException e) {
				System.out.println("Do not pay more than Tuition Fees, which is: Rs" + tuitionBalance);
			}
		}else {
			System.out.println("You have not enrolled in any course, your Tuition fee is: Rs" + tuitionBalance);
		}
	}
	
	//Show Info
	public void  showInfo() {
		System.out.println( "Name: " + firstName + " " + lastName +
				"\nGrade Year:" + gradeYear +
				"\nStudent ID:" + studentID +
				"\nCourses Enrolled:" + courses +
				"\nBalance: Rs" + tuitionBalance);
	}
}
