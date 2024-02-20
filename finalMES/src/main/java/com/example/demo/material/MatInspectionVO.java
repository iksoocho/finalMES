package com.example.demo.material;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatInspectionVO {
	private String matInsCode; // 자재검사코드
	private String matOrCode;	// 자재발주코드 FK
	private Integer matInsCount;	// 검사량
	private Integer matInsGood;		// 합격량
	private Integer matInsBad;		// 불량
	private String matNote;		// 비고
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matInsDate;	// 자재검사일자
	
	private String matName;
	private String matUnit;
	private String matStandard;
	private String businessName;
	private String businessCode;
	private String badMatContent;
	private String matOrCount;
	private String matManager;
	
	
	
//	public void insertMatInspection(MatInspectionVO matInspectionVO) {
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");
//            CallableStatement cs = conn.prepareCall("{call insert_mat_inspection(?, ?, ?, ?, ?)}");
//            
//            // 매개변수 설정
//            cs.setInt(1, matInspectionVO.getMatInsCount());
//            cs.setInt(2, matInspectionVO.getMatInsBad());
//            cs.setDate(3, new java.sql.Date(matInspectionVO.getMatInsDate().getTime()));
//            cs.setString(4, matInspectionVO.getMatOrCode());
//            cs.setString(5, matInspectionVO.getMatNote());
//
//            // 프로시저 실행
//            cs.execute();
//
//            // Connection과 Statement를 닫습니다.
//            cs.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
