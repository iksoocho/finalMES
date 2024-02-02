package com.example.demo.facility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.facility.mapper.FacManageMapper;

@SpringBootTest
public class FacilityTest {
	
	@Autowired
	FacManageMapper facManageMapper;
	
//	@Test
	public void 전체조회() {
		List<FacManageVO> list = facManageMapper.getfacList(null);
		System.out.println(list);
		assertThat(list.isEmpty()).isEqualTo(false);
	}

	
}
