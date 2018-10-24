package com.bla.dao;

import java.util.ArrayList;
import java.util.Map;

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
	public void delete(Integer v) throws Exception {
		amapper.delete(v);
	}
	
	public void deleteAll(ArrayList<Integer> v) throws Exception {
		amapper.deleteAll(v);
	}
	
	public void deleteNull(Long register_date) throws Exception{
		amapper.deleteNull(register_date);
	}

	@Override
	public AuctionVO select(Integer v) throws Exception {
		return amapper.select(v);
	}

	@Override
	public ArrayList<AuctionVO> select() throws Exception {
		return amapper.selectAll();
	}
	
	public ArrayList<AuctionVO> selectRealAll() throws Exception {
		return amapper.selectRealAll();
	}
	
	public ArrayList<AuctionVO> selectNull() throws Exception {
		return amapper.selectNull();
	}
	
	public ArrayList<AuctionVO> selectByDuedate() throws Exception {
		return amapper.selectByDuedate();
	}
	
	public int select(Long register_date) throws Exception {
		return amapper.selectByRegdate(register_date);
	}
	
	public ArrayList<AuctionVO> selectByCategory(int category_id) throws Exception {
		return amapper.selectByCategory(category_id);
	}
	
	public ArrayList<AuctionVO> selectByType(int type) throws Exception {
		return amapper.selectByType(type);
	}
	
	public void updateStatus(AuctionVO obj) throws Exception {
		amapper.updateStatus(obj);
	}
	
	public ArrayList<AuctionVO> selectAuctionByMember(AuctionVO obj) throws Exception{
		return amapper.selectAuctionByMember(obj);
	}
	
	public int selectMemberIdByAuct(Integer auct_id) throws Exception{//경매 올린 member_id 가져올려고 함
		return amapper.selectMemberIdByAuct(auct_id);
	}
	
	public ArrayList<AuctionVO> selectEndAuctionByMemberId(Map<String,Integer> obj) throws Exception{
		return amapper.selectEndAuctionByMemberId(obj);
	}
	
	public ArrayList<AuctionVO> searchTitleOrTag(String tag) throws Exception{
		return amapper.searchTitleOrTag(tag);
	}
	
}
