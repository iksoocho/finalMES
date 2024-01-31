package com.example.demo.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.sales.OrdVO;


@Mapper
public interface OrdMapper {
	public OrdVO getOrder(String ocd);
	public void OrdInsert(OrdVO ordVO);
	public List<OrdVO> getOrdList(OrdVO ordVO);
}
