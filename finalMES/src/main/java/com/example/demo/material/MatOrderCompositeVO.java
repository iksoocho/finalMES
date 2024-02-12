package com.example.demo.material;

import java.util.List;

import lombok.Data;

@Data
public class MatOrderCompositeVO {
	private MatOrderVO matOrderVO;
	private List<MatOrderInfoVO> matOrderInfoList;
}
