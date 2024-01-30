package com.example.demo.facility;

import java.util.Date;

import lombok.Data;

@Data
public class FacilityVO {
	String facCode;
	String businessCode;
	String facName;
	Number facHigtem;
	Number facLowesttem;
	Date facDate;
	String facInscycle;
	String facImage;
}
