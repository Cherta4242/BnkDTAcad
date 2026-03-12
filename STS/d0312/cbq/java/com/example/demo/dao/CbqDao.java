package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CbqDto;

@Repository
public class CbqDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(CbqDto dto) {
	    String sql = "INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount) "
	    			+"VALUES (?, ?, ?, ?, ?)";
	    return jdbcTemplate.update(sql, dto.getOrderno(), dto.getShopno(), dto.getOrderdate(), dto.getPcode(), dto.getAmount());
	}
	
	public List<CbqDto> showing() {
		String sql = "SELECT "
				+ "    TSHOP.SHOPNO AS SHOPNO, "
				+ "    TSHOP.SHOPNAME AS SHOPNAME, "
				+ "    SUBSTR(TORD.ORDERNO,1,4) || '-' || SUBSTR(TORD.ORDERNO,5,4) AS ORDERNO, "
				+ "    TO_CHAR(TO_DATE(TORD.ORDERDATE, 'YYYYMMDD'), 'YYYY-MM-DD') AS ORDERDATE, "
				+ "    TPRD.PCODE AS PCODE, "
				+ "    TPRD.PNAME AS PNAME, "
				+ "    TORD.AMOUNT AS AMOUNT, "
				+ "    TO_CHAR(TPRD.COST, 'FM999,999') AS COST, "
				+ "    TO_CHAR(TORD.AMOUNT * TPRD.COST, 'FM999,999') AS TOTAL_PRICE, "
				+ "    TO_CHAR(TORD.AMOUNT * TPRD.COST * (100 - TSHOP.DISCOUNT) / 100, 'FM999,999,999') AS DISCOUNT_PRICE "
				+ "FROM TBL_ORDER_202101 TORD "
				+ "JOIN TBL_SHOP_202101 TSHOP ON TORD.SHOPNO = TSHOP.SHOPNO "
				+ "JOIN TBL_PRODUCT_202101 TPRD ON TORD.PCODE = TPRD.PCODE "
				+ "ORDER BY TORD.ORDERNO ASC";
		
	    return jdbcTemplate.query(sql, (rs, rowNum) -> {
	        CbqDto dto = new CbqDto();
	        dto.setShopno(rs.getString("SHOPNO"));
	        dto.setShopname(rs.getString("SHOPNAME"));
	        dto.setOrderno(rs.getString("ORDERNO"));
	        dto.setOrderdate(rs.getString("ORDERDATE"));
	        dto.setPcode(rs.getString("PCODE"));
	        dto.setPname(rs.getString("PNAME"));
	        dto.setAmount2(rs.getString("AMOUNT"));
	        dto.setCost(rs.getInt("COST"));
	        dto.setTotalprice(rs.getInt("TOTAL_PRICE"));
	        dto.setDiscountprice(rs.getInt("DISCOUNT_PRICE"));
	        
	        return dto;
	    });
		
		
	}

}
