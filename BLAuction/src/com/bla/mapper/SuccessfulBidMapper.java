package com.bla.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.vo.SuccessfulBidVO;

@Repository("smapper")
public interface SuccessfulBidMapper {
	public ArrayList<SuccessfulBidVO> select (Integer bid_id);
	public ArrayList<SuccessfulBidVO> selectall ();
	public void insert (SuccessfulBidVO obj);
	public void update (SuccessfulBidVO obj);
	public ArrayList<SuccessfulBidVO> selectMySuccessfulBid(Integer member_id);
}
