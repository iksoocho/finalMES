package com.example.demo.produce;

import java.util.List;

import lombok.Data;

@Data
public class PlanCompositeVO {
	 private PlanVO planVO;
	 private List<PlanDVO> planDVOList;
	 private PlanOrdVO planOrdVO;
}
