package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatOutputVO {
	private String matOutCode;
	private String matLotCode;
	private String resultCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matOutDate;
	private int matOutCount;
}
