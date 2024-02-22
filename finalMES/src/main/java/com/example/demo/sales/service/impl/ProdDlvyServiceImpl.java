package com.example.demo.sales.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sales.mapper.ProdDlvyMapper;
import com.example.demo.sales.service.ProdDlvyService;
import com.example.demo.sales.vo.delivery.DlvyCompositeVO;
import com.example.demo.sales.vo.delivery.ProdDetailDlvyDVO;
import com.example.demo.sales.vo.delivery.ProdDetailDlvyVO;
import com.example.demo.sales.vo.delivery.ProdDetailUpdateDVO;
import com.example.demo.sales.vo.delivery.ProdDlvyDVO;
import com.example.demo.sales.vo.delivery.ProdDlvyVO;
import com.example.demo.sales.vo.order.OrderDateDVO;

@Service
public class ProdDlvyServiceImpl implements ProdDlvyService {

	@Autowired
	private ProdDlvyMapper prodDlvyMapper;

	@Override
	public ProdDlvyVO saveDlvy(ProdDlvyVO prodDlvyVO) {
		prodDlvyMapper.saveDlvy(prodDlvyVO);
		return prodDlvyVO;
	}

	@Override
	public ProdDetailDlvyVO saveDetailDlvy(ProdDetailDlvyVO prodDetailDlvyVO) {
		prodDlvyMapper.saveDetailDlvy(prodDetailDlvyVO);
		return prodDetailDlvyVO;
	}

	@Override
	@Transactional
	public void saveDlvyWithDetail(DlvyCompositeVO dlvyCompositeVO) {

		// out_list 테이블에 데이터 삽입(출고서 등록)
		prodDlvyMapper.saveDlvy(dlvyCompositeVO.getProdDlvyVO());

		// 루프 돌면서 out_d_list 테이블에 데이터 삽입
		for (int i = 0; i < dlvyCompositeVO.getProdDetailDlvyList().size(); i++) {
			ProdDetailDlvyVO dvo = dlvyCompositeVO.getProdDetailDlvyList().get(i);
			dvo.setOutCode(dlvyCompositeVO.getProdDlvyVO().getOutCode());
			prodDlvyMapper.saveDetailDlvy(dvo);

			
			 
			 
		}
		
		 // 주문서 상태 업데이트
		 prodDlvyMapper.updateOrderState(dlvyCompositeVO.getOrderVO().getOrdCode());
		 
		
		
		System.out.println("등록성공");
	}
	
	

	@Override
	public List<ProdDlvyDVO> getProdDlvyList(ProdDlvyDVO prodDlvyDVO) {
		// TODO Auto-generated method stub
		return prodDlvyMapper.prodDlvyList(prodDlvyDVO);
	}

	@Override
	public List<ProdDetailDlvyDVO> getProdDetailDlvyList(String outCode) {
		// TODO Auto-generated method stub
		return prodDlvyMapper.prodDetailDlvyList(outCode);
	}

	@Override
    @Transactional
    public int updateOutDDate(List<ProdDetailUpdateDVO> prodDetailUpdateList) {
        int totalCount = 0;

        for (ProdDetailUpdateDVO prodDetailUpdateDVO : prodDetailUpdateList) {
            int updatedCount = prodDlvyMapper.updateOutDDate(prodDetailUpdateDVO);
            totalCount += updatedCount;
            
            // 재고 업데이트
	        prodDlvyMapper.updateInventory(prodDetailUpdateDVO.getProdLotCode(),prodDetailUpdateDVO.getOutCount());
	        
        }
        // 출고서 상태 업데이트
        prodDlvyMapper.updateOutState(prodDetailUpdateList.get(0).getOutCode());
        
        

        return totalCount;
    }

	@Override
	public List<ProdDlvyDVO> getDlvyListByOutState(String outState) {
		// TODO Auto-generated method stub
		return prodDlvyMapper.getDlvyListByOutState(outState);
	}

	@Override
	public List<ProdDlvyDVO> getDlvyListByDateRange(OrderDateDVO orderDateDVO) {
		// TODO Auto-generated method stub
		return prodDlvyMapper.getDlvyListByDateRange(orderDateDVO);
	}

	
	
	
	

}
