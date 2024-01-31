package com.example.demo.facility.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.facility.FacManageVO;

@Mapper
public interface FacManageMapper {
	public FacManageVO getFacManage(String facCode);
	public List<FacManageVO> getfacList(FacManageVO facManageVO);
}
