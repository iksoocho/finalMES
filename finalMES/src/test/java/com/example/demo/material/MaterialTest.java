package com.example.demo.material;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.material.mapper.MaterialMapper;

@SpringBootTest
public class MaterialTest {
		
		@Autowired
		MaterialMapper materialMapper;

		@Test
		public void 전체조회() {
			List<MatOrderVO> list = materialMapper.getMatList(null);
			System.out.println(list);
			assertThat(list.isEmpty()).isEqualTo(false);
		}
		
		
		//등록
		@Test
		public void insertInfo() {
			MatOrderVO matOrderVO = new MatOrderVO();
			matOrderVO.setMatOrCode(null);
			matOrderVO.setMatOrName(null);
			matOrderVO.setMatCode(null);
			matOrderVO.setMatOrDate(null);
			matOrderVO.setMatOrManager(null);
			
			int result = materialMapper.insertMatOrder(matOrderVO);
			assertNotEquals(result, 0);
		}
		
	
}
