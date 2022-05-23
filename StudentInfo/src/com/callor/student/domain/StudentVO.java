package com.callor.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO {

	private String stNum;
	private String stName;
	private String stDept;
	private Integer stGrade;
	private String stTel;
	
	
}
