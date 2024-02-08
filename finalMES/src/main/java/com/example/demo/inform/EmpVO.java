package com.example.demo.inform;



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
	String userState;
	
	String deptName;
	
	
}
