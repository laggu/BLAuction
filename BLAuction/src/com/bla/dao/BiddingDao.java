package com.bla.dao;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bla.frame.Dao;
import com.bla.mapper.BiddingMapper;
import com.bla.vo.AuctionVO;
import com.bla.vo.BiddingVO;

@Repository("bdao")
public class BiddingDao implements Dao<BiddingVO,Integer>{

	@Resource(name="bmapper")
	BiddingMapper bmapper;
	
	@Override
	public void insert(BiddingVO t) throws Exception {
		// TODO Auto-generated method stub
		bmapper.insert(t);
	}

	@Override
	public void update(BiddingVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BiddingVO select(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return bmapper.select(v);
	}

	@Override
	public ArrayList<BiddingVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Integer> selectAuctIdByMemberId(Integer member_id) throws Exception{
		return bmapper.selectAuctIdByMemberId(member_id);
	};
	
	public Long selectBidMaxPrice(AuctionVO auction) throws Exception{
		return bmapper.selectBidMaxPrice(auction);
	}
	
	public ArrayList<BiddingVO> selectAuctionBiddingList(Integer auct_id) throws Exception{
		return bmapper.selectAuctionBiddingList(auct_id);
	}
	
	public Long selectMemberBidMaxPrice(Map<String,Integer> obj) throws Exception {
		return bmapper.selectMemberBidMaxPrice(obj);
	}
	
	public BiddingVO selectBididByAuctId(Integer auct_id) throws Exception{
		return bmapper.selectBididByAuctId(auct_id);
	}
}
