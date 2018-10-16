package com.bla.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bla.frame.Dao;
import com.bla.mapper.AuctionMapper;
import com.bla.vo.AuctionVO;

@Repository("adao")
public class AuctionDao implements Dao<AuctionVO, Integer>{

	@Resource(name="amapper")
	AuctionMapper amapper;
	
	@Override
	public void insert(AuctionVO t) throws Exception {
		amapper.insert(t);
	}
	
	public void insertDown(AuctionVO t) throws Exception {
		amapper.insertDown(t);
	}

	@Override
	public void update(AuctionVO t) throws Exception { // 삭제?
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Integer v) throws Exception { // 삭제?
		// TODO Auto-generated method stub
	}

	@Override
	public AuctionVO select(Integer v) throws Exception {
		return amapper.select(v);
	}

	@Override
	public ArrayList<AuctionVO> select() throws Exception {
		return amapper.selectAll();
	}
	
	public int select(Long register_date) throws Exception {
		return amapper.selectByRegdate(register_date);
	}
	
	public ArrayList<AuctionVO> selectByCategory(int category_id) throws Exception {
		return amapper.selectByCategory(category_id);
	}
	
	public void updateStatus(AuctionVO obj) throws Exception {
		amapper.updateStatus(obj);
	}
	
}
