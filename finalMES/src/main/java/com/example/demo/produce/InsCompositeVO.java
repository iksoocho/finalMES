package com.example.demo.produce;

import java.util.List;

import lombok.Data;

@Data
public class InsCompositeVO {
	private PlanInsVO planInsVO;
	private List<PlanInsDVO> planInsDList;
	private PlanVO planVO;
}
