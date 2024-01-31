package com.example.demo.produce;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.produce.mapper.InsMapper;

@SpringBootTest
public class ProduceMapperTest {

	@Autowired
	InsMapper insMapper;
	
	@Test
	public void insList() {
		List<ProdInsVO> list = insMapper.getInsList();
		assertThat(list.isEmpty()).isEqualTo(false);
	}
	
}
