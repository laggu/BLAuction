package com.bla.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.vo.AuctionVO;

@Repository("amapper")
public interface AuctionMapper {
	public AuctionVO select(Integer id);
	public int selectByRegdate(Long register_date);
	public ArrayList<AuctionVO> selectByCategory(int category_id);
	public ArrayList<AuctionVO> selectAll();
	public void insert(AuctionVO obj);
	public void insertDown(AuctionVO obj);
	public void updateStatus(AuctionVO obj);
	public ArrayList<AuctionVO> selectAuctionByMember(AuctionVO obj);//mypage 나의 경매 리스트
	public int selectMemberIdByAuct(Integer auct_id);
	public ArrayList<AuctionVO> selectEndAuctionByMemberId(Integer auct_id);
}
