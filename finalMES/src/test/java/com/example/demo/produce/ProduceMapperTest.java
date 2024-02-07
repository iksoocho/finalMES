package com.example.demo.produce;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.produce.mapper.InsMapper;
import com.example.demo.produce.mapper.PlanMapper;
import com.example.demo.produce.mapper.WorkMapper;

@SpringBootTest
public class ProduceMapperTest {

	@Autowired
	PlanMapper planMapper;
	
	@Autowired
	InsMapper insMapper;
	
	@Autowired
	WorkMapper workMapper;
	
	//등록 테스트
	@Test
	public void check() {
		String dinsCode = "DINS001";
		String procCode = "proc02";
		
		List<WorkMidRegistVO> vo = workMapper.checkWorkMidRegist(dinsCode, procCode);
		System.out.println(vo);
		
		
		
	}
	
	
//	//공정, 설비목록 조회 테스트
//	@Test
//	public void facList() {
//		
//		List<ProcessVO> proc = workMapper.getProcData();
//		String code = "proc01";
//	    
//		List<FacCateVO> list = workMapper.getFacSelect(code);
//		System.out.println("================================");
//		System.out.println(proc);
//		System.out.println("================================");
//		System.out.println(list);
//		System.out.println("================================");
//		
//		
//		assertThat(list.isEmpty()).isEqualTo(false);
//	}
	
	//생산계획 + 상세계획 여러건 입력 테스트
//	@Test
//    public void insertProdPlanAndDPlanTest() {
//        // 테스트에 사용할 데이터
//        String ordCode = "A003-20240125-001";
//        List<String> dPlanDataList = new ArrayList<>();
//        dPlanDataList.add("latte001");
//        dPlanDataList.add("caramel001");
//        String dPlanData = String.join(",", dPlanDataList);
//        System.out.println(dPlanData);
//
//        // Mapper 메서드 호출
//        int result = planMapper.insertProdPlanAndDPlan(ordCode, dPlanData);
//        
//        // 테스트 결과 확인
//        assertNotEquals(result, 0);
//    }
	
	
	
	
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
	
//	@Test
//	public void workForm() {
//		String dInsCode = "DINS002";
//		ProdInsDetailVO vo = insMapper.getCheckDetailList(dInsCode);
//		System.out.println("================================");
//		System.out.println(vo);
//		System.out.println("================================");
//		assertThat(vo == null).isEqualTo(false);
//	}
	
	
//	@Test
//	public void workLoad() {
//		String prodCode = "ame001";
//		List<WorkLoadVO> list = workMapper.getLoadData(prodCode);
//		System.out.println("================================");
//		System.out.println(list);
//		System.out.println("================================");
//		assertThat(list.isEmpty()).isEqualTo(false);	
//		
//	}
	
}
