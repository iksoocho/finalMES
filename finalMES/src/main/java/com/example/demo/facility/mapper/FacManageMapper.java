package com.example.demo.facility.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.facility.FacManageVO;
import com.example.demo.facility.FacNotopVO;

@Mapper
public interface FacManageMapper {
	public FacManageVO getFacManage(String facCode);
	public List<FacManageVO> getfacList(FacManageVO facManageVO);
	public int insertFac(FacManageVO facManageVO);
	
	//비가동
	public FacNotopVO getFacNotop(String facCode);
	public List<FacNotopVO> getfacNotList();
	public int insertFacNot(FacNotopVO facNotopVO);
	public int updateFacNot(FacNotopVO facNotopVO);
	
}
