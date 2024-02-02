package com.example.demo.produce;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.produce.mapper.InsMapper;

@SpringBootTest
public class ProduceMapperTest {

	@Autowired
	InsMapper insMapper;
	
//	@Test
//	public void insList() {
//		List<ProdInsVO> list = insMapper.getInsList();
//		String code = null;
//	    if (!list.isEmpty()) {
//	        ProdInsVO firstProdInsVO = list.get(0); // 첫 번째 ProdInsVO 추출
//	        code = firstProdInsVO.getInsCode();
//	    }
//		List<ProdInsDetailVO> detailList = insMapper.getInsDetailList(code);
//		System.out.println("================================");
//		System.out.println(list);
//		System.out.println("================================");
//		System.out.println(detailList);
//		System.out.println("================================");
//		
//		
//		assertThat(list.isEmpty()).isEqualTo(false);
//	}
	
//	@Test
//	public void insDetailList() {
//		String code = "INS001";
//		List<ProdInsDetailVO> list = insMapper.getInsDetailList(code);
//		System.out.println(list);
//		assertThat(list.isEmpty()).isEqualTo(false);	
//	}
	
	@Test
	public void workForm() {
		String dInsCode = "DINS002";
		ProdInsDetailVO vo = insMapper.getCheckDetailList(dInsCode);
		System.out.println("================================");
		System.out.println(vo);
		System.out.println("================================");
		assertThat(vo == null).isEqualTo(false);
	}
	
	
}
