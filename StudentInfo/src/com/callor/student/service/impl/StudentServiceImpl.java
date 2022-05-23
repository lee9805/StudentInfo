package com.callor.student.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.callor.student.domain.StudentVO;
import com.callor.student.service.StudentService;
import com.callor.utils.Line;

public class StudentServiceImpl implements StudentService {

	private List<StudentVO> ListVO ;
	private FileReader fileReader;
	private BufferedReader buffer; 
	
	public StudentServiceImpl() {

		ListVO = new ArrayList<>();
	}
	
	
	@Override
	public void inputStudent() {
		
		String sFile = "./src/Student.txt";
		try {
			
			fileReader = new FileReader(sFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while(true) {
				reader = buffer.readLine();
				if(reader ==null) {
					break;
				}
				String[] students = reader.split(":");
				StudentVO sVO = new StudentVO();
				sVO.setStNum(students[0]);
				sVO.setStName(students[1]);
				sVO.setStDept(students[2]);
				sVO.setStGrade(1);
				sVO.setStTel(students[4]);
				ListVO.add(sVO);
			}
			buffer.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void printStudent() {
		
		System.out.println(Line.dLine(50));
		System.out.println("성적일람표");
		System.out.println(Line.sLine(50));
		System.out.println("학번\t이름\t학과\t학년\t전화번호");
		System.out.println(Line.sLine(50));
		
		for(StudentVO sVO : ListVO) {
			
			System.out.print(sVO.getStNum() + "\t");
			System.out.print(sVO.getStName() + "\t");
			System.out.print(sVO.getStDept() + "\t");
			System.out.print(sVO.getStGrade() + "\t");
			System.out.print(sVO.getStTel() + "\t");
			

		
	}
	}

}
