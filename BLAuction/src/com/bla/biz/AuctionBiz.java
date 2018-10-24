package com.bla.biz;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bla.dao.AuctionDao;
import com.bla.frame.Biz;
import com.bla.vo.AuctionVO;

@Repository("abiz")
public class AuctionBiz implements Biz<AuctionVO, Integer>{

	@Resource(name="adao")
	AuctionDao adao;
	
	@Override
	public void register(AuctionVO t) throws Exception {
		adao.insert(t);
	}
	
	public void registerDown(AuctionVO t) throws Exception {
		adao.insertDown(t);
	}

	@Override
	public void modify(AuctionVO t) throws Exception {
		adao.update(t);
	}

	@Override
	public void remove(Integer v) throws Exception {
		adao.delete(v);
	}
	
	public void removeAll(ArrayList<Integer> v) throws Exception {
		adao.deleteAll(v);
	}
	
	public void removeNull(Long register_date) throws Exception{
		adao.deleteNull(register_date);
	}

	@Override
	public AuctionVO get(Integer v) throws Exception {
		return adao.select(v);
	}
	
	public ArrayList<AuctionVO> getByStatus(String status) throws Exception {
		return adao.selectByStatus(status);
	}

	@Override
	public ArrayList<AuctionVO> get() throws Exception {
		return adao.select();
	}
	
	public ArrayList<AuctionVO> getRealAll() throws Exception {
		return adao.selectRealAll();
	}
	
	public ArrayList<AuctionVO> getNull() throws Exception {
		return adao.selectNull();
	}
	
	public ArrayList<AuctionVO> getByDuedate() throws Exception {
		return adao.selectByDuedate();
	}
	
	public int get(Long register_date) throws Exception {
		return adao.select(register_date);
	}
	
	public ArrayList<AuctionVO> getByCategory(int category_id) throws Exception {
		return adao.selectByCategory(category_id);
	}
	
	public ArrayList<AuctionVO> getByType(int type) throws Exception {
		return adao.selectByType(type);
	}
	
	public ArrayList<AuctionVO> getByCategory_admin(int category_id) throws Exception {
		return adao.selectByCategory_admin(category_id);
	}
	
	public ArrayList<AuctionVO> getByType_admin(int type) throws Exception {
		return adao.selectByType_admin(type);
	}
	
	public void updateStatus(AuctionVO obj) throws Exception{
		adao.updateStatus(obj);
	}
	
	public ArrayList<AuctionVO> selectAuctionByMember(AuctionVO obj) throws Exception{
		return adao.selectAuctionByMember(obj);
	}
	
	public int selectMemberIdByAuct(Integer auct_id) throws Exception{//경매 올린 member_id 가져올려고 함
		return adao.selectMemberIdByAuct(auct_id);
	}
	public ArrayList<AuctionVO> selectEndAuctionByMemberId(Map<String,Integer> obj) throws Exception{
		return adao.selectEndAuctionByMemberId(obj);
	}
	public ArrayList<AuctionVO> selectFinishedAuctIDByCurrentTime(Long current_time) throws Exception{
		return adao.selectFinishedAuctIDByCurrentTime(current_time);
	}
	public ArrayList<AuctionVO> searchTitleOrTag(String tag) throws Exception{
		return adao.searchTitleOrTag(tag);
	}
}
