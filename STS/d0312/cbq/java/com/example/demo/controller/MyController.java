package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.CbqDao;
import com.example.demo.dto.CbqDto;

@Controller
public class MyController {
	
    
    
    // 페이지 이동
	// -------------------------------------------------------------------------
	@RequestMapping("/")
	public String root() {
		System.out.println("index.jsp 실행합니다!");
		
		return "index";
	}
	@RequestMapping("/index")
	public String indexPage() {
		System.out.println("index.jsp 접속");
		return "index";
	}
	@RequestMapping("/order")
	public String orderpage() {
		System.out.println("주문등록화면 접속");
		return "order";
	}
	@RequestMapping("/ordershow")
	public String orderViewPage() {
		System.out.println("주문목록조회화면 접속");
		return "ordershow";
	}
	@RequestMapping("/ordershop")
	public String shopOrderPage() {
		System.out.println("점포별주문현황화면 접속");
		return "ordershop";
	}
	@RequestMapping("/ordercode")
	public String prdCodePage() {
		System.out.println("제품코드조회화면 접속");
		return "ordercode";
	}
	
	
	// 기능 정의
	// -------------------------------------------------------------------------
	@Autowired
	private CbqDao dao;
	
    @RequestMapping("/orderisrt")
    public @ResponseBody String insertOrder(@RequestBody CbqDto dto) {
        System.out.println("주문 등록");

        System.out.println("orderno: " + dto.getOrderno());
        System.out.println("shopno: " + dto.getShopno());
        System.out.println("orderdate: " + dto.getOrderdate());
        System.out.println("pcode: " + dto.getPcode());
        System.out.println("amount: " + dto.getAmount());
        
        int result = dao.insert(dto);
        System.out.println("dao result : " + result);
        if(result == 0) {
        	return "no";
        }
        return "ok";
    }
	
	
}
