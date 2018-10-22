package com.bla.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bla.vo.AuctionVO;
import com.bla.vo.BiddingVO;

@Repository("bmapper")
public interface BiddingMapper {
	public ArrayList<Integer> selectAuctIdByMemberId(Integer member_id);
	public Long selectBidMaxPrice(AuctionVO auction);
	public Long selectMemberBidMaxPrice(Map<String,Integer> obj);
	public ArrayList<BiddingVO> selectAuctionBiddingList(Integer auct_id);
	public void insert(BiddingVO obj);
	public BiddingVO select(Integer bid_id);
	public BiddingVO selectBididByAuctId(Map<String,Integer> obj);
}
