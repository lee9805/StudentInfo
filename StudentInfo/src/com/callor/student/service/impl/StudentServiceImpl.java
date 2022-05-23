package com.callor.student.service.impl;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.domain.StudentVO;
import com.callor.student.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private List<StudentVO> ListVO ;
	private String saveFileName;
	private Scanner scan;
	
	public StudentServiceImpl() {

		ListVO = new ArrayList<>();
		scan = new Scanner(System.in);
		saveFileName = "./src/Student.txt";
	}
	
	
	@Override
	public void inputStudent() {

		while(true) {
			System.out.println("학생학번입력(QUIT:종료) >> ");
			String stNum = scan.nextLine();
			if(stNum.equals("QUIT")) {
				break;
			}
			System.out.println("학생이름입력(QUIT:종료) >> ");
			String stName = scan.nextLine();
			
			System.out.println("학생학과입력(QUIT:종료) >> ");
			String stDept = scan.nextLine();

			System.out.println("학생학년입력(QUIT:종료) >> ");
			String stGrade = scan.nextLine();
			Integer intGrade = Integer.valueOf(stGrade);
			
			System.out.println("학생전화번호입력(QUIT:종료) >> ");
			String stTel = scan.nextLine();
			
			StudentVO sVO = new StudentVO();

			try {
				FileInputStream is = new FileInputStream(saveFileName);
				Scanner fileScan = new Scanner(is);
				while(fileScan.hasNext()) {
					String line = fileScan.nextLine();
					String[] sts = line.split(":");
					
					StudentVO stVO = StudentVO.builder()
											.stNum(sts[0])
											.stName(sts[1])
											.stDept(sts[2])
											.stGrade(Integer.valueOf(sts[3]))
											.stTel(sts[3])
											.build();
					ListVO.add(sVO);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			for(StudentVO stVO : ListVO) {
				System.out.println(stVO.toString());
			}
		}
	}

	@Override
	public void printStudent() {
		
	}


	@Override
	public void saveStudent() {
		
		FileOutputStream fileOut = null;
		BufferedOutputStream buffer = null;
		
		try {
			fileOut = new FileOutputStream(saveFileName);
			buffer = new BufferedOutputStream(fileOut);
			for(StudentVO scVO : ListVO) {
				String writeStr = "";
				writeStr += String.format("%s:", scVO.getStNum());
				writeStr += String.format("%s:", scVO.getStName());
				writeStr += String.format("%s:", scVO.getStDept());
				writeStr += String.format("%s:", scVO.getStGrade());
				writeStr += String.format("%s\n", scVO.getStTel());
				
				buffer.write(writeStr.getBytes());
			}
			buffer.flush();
			buffer.close();
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
