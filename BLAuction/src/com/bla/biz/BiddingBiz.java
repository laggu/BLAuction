package com.bla.biz;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bla.dao.BiddingDao;
import com.bla.frame.Biz;
import com.bla.vo.AuctionVO;
import com.bla.vo.BiddingVO;

@Service("bbiz")
public class BiddingBiz implements Biz<BiddingVO,Integer>{

	@Resource(name="bdao")
	BiddingDao bdao;
	
	@Override
	public void register(BiddingVO t) throws Exception {
		// TODO Auto-generated method stub
		bdao.insert(t);
	}

	@Override
	public void modify(BiddingVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BiddingVO get(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return bdao.select(v);
	}

	@Override
	public ArrayList<BiddingVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Integer> selectAuctIdByMemberId(Integer member_id) throws Exception{
		return bdao.selectAuctIdByMemberId(member_id);
	}
	
	public Long selectBidMaxPrice(AuctionVO auction) throws Exception{
		return bdao.selectBidMaxPrice(auction);
	}
	
	public Long selectMemberMaxPrice(Map<String,Integer> obj) throws Exception{
		return bdao.selectMemberBidMaxPrice(obj);
	}
	
	public ArrayList<BiddingVO> selectAuctionBiddingList(Integer auct_id) throws Exception{
		return bdao.selectAuctionBiddingList(auct_id);
	}
	
	public BiddingVO selectBididByAuctId(Map<String,Integer> obj) throws Exception{
		return bdao.selectBididByAuctId(obj);
	}
}
