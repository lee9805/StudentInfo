package com.callor.student.controller;

import com.callor.student.service.impl.StudentServiceImpl;

public class StudentController {

	public static void main(String[] args) {
		
		StudentServiceImpl impl = new StudentServiceImpl();
		
		impl.inputStudent();
		impl.printStudent();
	}
	
}
