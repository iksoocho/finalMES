package com.example.demo.produce.mapper;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.ProcessVO;
import com.example.demo.produce.ProdProgressJoinVO;
import com.example.demo.produce.WorkLoadVO;
import com.example.demo.produce.WorkMidRegistVO;
import com.example.demo.produce.WorkResultVO;

public interface WorkMapper {
	public List<WorkLoadVO> getLoadData(String prodCode);
	public List<FacCateVO> getFacSelect(String procCode);
	public List<ProcessVO> getProcData();
	public int insertWorkMidRegist(WorkMidRegistVO workMidRegistVO);
	public List<WorkMidRegistVO> checkWorkMidRegist(@Param("dinsCode") String dinsCode, @Param("procCode") String procCode);
	public int updateWorkMidRegist(WorkMidRegistVO workMidRegistVO);
	public List<ProdProgressJoinVO> getProdProgress(@Param("dinsCode") String dinsCode);
	public int insertWorkResult(@Param("dinsCode") String dinsCode);
	
}
