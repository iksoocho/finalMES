package com.example.demo.facility.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.facility.FacNotopVO;

@Mapper
public interface FacNotopMapper {
	public FacNotopVO getFacNotop(String facCode);
	public List<FacNotopVO> getfacNotList(FacNotopVO facNotopVO);
	public int insertFacNot(FacNotopVO facNotopVO);
}
