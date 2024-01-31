package com.example.demo.emp;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
public class EmpVO { 
	String userCode;
	String deptCode;
	String userPassword;
	String userName;
	String userEmail;
	String userPhone;
	String userAuthority;
	
	private String employeeId;
	String firstName;
	String lastName;
	String email;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date hireDate;
	 
	int salary;
	String jobId;
	String departmentId;
	String managerId;
}
