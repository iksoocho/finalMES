package com.example.demo.material;

import java.util.List;

import com.example.demo.sales.vo.business.BusinessListVO;

import lombok.Data;

@Data
public class MatOrderCompositeVO {
	private MatOrderVO matOrderVO;
	private List<MatOrderInfoVO> matOrderInfoList;
	private MatOrderInfoVO matOrderInfoVO;
	private BusinessListVO businessListVO;
}
