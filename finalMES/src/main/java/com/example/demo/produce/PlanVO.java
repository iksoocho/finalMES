package com.example.demo.produce;

import java.util.Date;
import lombok.Data;

@Data
public class PlanVO {
	private String planCode;
	private String orderCode;
	private String planTitle;
	private Date planDate;
	private String planNote;
}
