package com.bla.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.vo.BiddingVO;

@Repository("bmapper")
public interface BiddingMapper {
	public ArrayList<Integer> selectAuctIdByMemberId(Integer member_id);
	public BiddingVO selectMaxPrice(Integer auct_id);
	public ArrayList<BiddingVO> selectAuctionBiddingList(Integer auct_id);
	public void insert(BiddingVO obj);
}
