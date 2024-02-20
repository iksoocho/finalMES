package com.example.demo.sales.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.sales.service.OrdService;
import com.example.demo.sales.service.ProdDlvyService;
import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.delivery.DlvyCompositeVO;
import com.example.demo.sales.vo.delivery.ProdDetailDlvyDVO;
import com.example.demo.sales.vo.delivery.ProdDetailUpdateDVO;
import com.example.demo.sales.vo.delivery.ProdDlvyDVO;
import com.example.demo.sales.vo.delivery.ProdDlvyVO;
import com.example.demo.sales.vo.employee.EmployeeVO;
import com.example.demo.sales.vo.order.OrderDVO;
import com.example.demo.sales.vo.order.OrderDateDVO;
import com.example.demo.sales.vo.order.OrderDetailDVO;
import com.example.demo.sales.vo.order.OrderDetailVO;
import com.example.demo.sales.vo.order.OrderStateDVO;
import com.example.demo.sales.vo.order.OrderVO;
import com.example.demo.sales.vo.product.ProductListVO;
import com.example.demo.sales.vo.product.ProductLotVO;

/**
 * 주문서 관리, 완제품출고 관리
 * 
 * @author 윤성오
 *
 */
@Controller
public class SalesController {

	@Autowired
	private OrdService ordService;

	@Autowired
	private ProdDlvyService prodDlvyService;

	/**
	 * 보류
	 * 
	 * @param ordCode
	 * @param model
	 * @return sales/orderList
	 */
	@GetMapping("/getOrder/{ordCode}") // 단건조회에 대한 상세목록도 같이 출력하게 SQL문 변경
	public String getOrder(@PathVariable String ordCode, Model model) {
		OrderVO order = ordService.getOrder(ordCode);
		model.addAttribute("order", order);
		return "sales/orderList";
	}

	/**
	 * 주문등록페이지. (거래처, 품목 리스트)
	 * 
	 * @param model
	 * @return sales/orderInsert
	 */
	@GetMapping("/orderInsert")
	public String getBusinessList(Model model) {
		List<BusinessListVO> businessList = ordService.getBusinessList();
		List<ProductListVO> productList = ordService.getProductList();
		List<EmployeeVO> employeeList = ordService.getEmployeeList();
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("businessList", businessList);
		model.addAttribute("productList", productList);
		return "sales/orderInsert";
	}

	@PostMapping("/saveOrder")
	@ResponseBody
	public String saveOrder(@RequestBody OrderVO OrderVO) {
		// OrderVO에는 주문서 정보가 담겨있을 것으로 가정합니다.
		String msg = "주문서 등록이 완료되었습니다";
		// 주문서 등록 로직 수행
		ordService.saveOrder(OrderVO);
		return msg;
	}

	// 출고서등록.
	@PostMapping("/saveDlvy")
	@ResponseBody
	public String saveDlvy(@RequestBody DlvyCompositeVO dlvyCompositeVO) {
		String msg;
		prodDlvyService.saveDlvyWithDetail(dlvyCompositeVO);
		msg = "출고등록이 완료되었습니다";
		return msg;
	}

	// 출고서 리스트.
	@GetMapping("/inOutList")
	public String getProdDlvyList(Model model) {
		List<ProdDlvyDVO> prodDlvyList = prodDlvyService.getProdDlvyList(null);
		model.addAttribute("prodDlvyList", prodDlvyList);
		return "sales/inOutList";
	}

	@GetMapping("/orderList")
	public String getOrderList(Model model) {
		List<OrderVO> orderList = ordService.getOrderList(null);
		model.addAttribute("orderList", orderList);
		return "sales/orderList";
	}

	@GetMapping("/orderDetailList/{ordCode}")
	@ResponseBody
	public List<OrderDetailDVO> getOrderDetailList(@PathVariable String ordCode) {
		List<OrderDetailDVO> orderDetailList = ordService.getOrderDetailList(ordCode);
		return orderDetailList;
	}

	@GetMapping("/productLotList/{prodCode}")
	@ResponseBody
	public List<ProductLotVO> getProductLotList(@PathVariable String prodCode) {
		List<ProductLotVO> productLotList = ordService.getProductLotList(prodCode);
		return productLotList;
	}

	// 출고관리 페이지로 거래처, 주문서 뿌려주는 컨트롤러
	@GetMapping("/inOutManage")
	public String getInOutList(Model model, OrderVO orderVO) {
		List<BusinessListVO> businessList = ordService.getBusinessList();
		// 출고전 주문서 리스트
		orderVO.setOrdState("o4");
		List<OrderVO> orderList = ordService.getOrderList(orderVO);
		List<EmployeeVO> employeeList = ordService.getEmployeeList();
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("businessList", businessList);
		model.addAttribute("orderList", orderList);
		return "sales/inOutManage";
	}

	// 출고 상세 목록 By ordCode
	@GetMapping("/prodDetailDlvyList/{ordCode}")
	@ResponseBody
	public List<ProdDetailDlvyDVO> getprodDetailDlvyList(@PathVariable String ordCode) {
		List<ProdDetailDlvyDVO> prodDetailDlvyList = prodDlvyService.getProdDetailDlvyList(ordCode);
		return prodDetailDlvyList;
	}

	// 출고 상세 날짜 업데이트 및 상태 자동업데이트
	@PutMapping("/updateOutDDate")
	@ResponseBody
	public String updateOutDDate(@RequestBody List<ProdDetailUpdateDVO> prodDetailUpdateDVOList) {
	    String msg = "날짜 및 상태 업데이트가 완료되었습니다";
	    prodDlvyService.updateOutDDate(prodDetailUpdateDVOList);
	    return msg;
	}
	
	@PutMapping("/updateOrderState")
	@ResponseBody
	public String updateOrderState(@RequestBody OrderStateDVO orderStateDVO) {
		String msg = "상태 업데이트가 완료되었습니다.";
		ordService.updateOrderState(orderStateDVO);
		return msg;
	}
	
	@PostMapping("/orderListByDateRange")
	@ResponseBody
	public List<OrderVO> getOrderListByDateRange(@RequestBody OrderDateDVO orderDateDVO) {
	    // orderService를 사용해서 주문 목록을 가져옴
		System.out.println("입력데이터확인 : " + orderDateDVO);
	    List<OrderVO> orderList = ordService.getOrderListByDateRange(orderDateDVO);
	    System.out.println("데이타 확인:" + orderList);
	    
	    return orderList;
	}
}
