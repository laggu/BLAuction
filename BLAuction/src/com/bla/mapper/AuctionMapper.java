package com.bla.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bla.vo.AuctionVO;

@Repository("amapper")
public interface AuctionMapper {
	public AuctionVO select(Integer id);
	public int selectByRegdate(Long register_date);
	public ArrayList<AuctionVO> selectByCategory(int category_id);
	public ArrayList<AuctionVO> selectByType(int type);
	public ArrayList<AuctionVO> selectAll();
	public ArrayList<AuctionVO> selectByDuedate();
	public void insert(AuctionVO obj);
	public void insertDown(AuctionVO obj);
	public void updateStatus(AuctionVO obj);
	public ArrayList<AuctionVO> selectAuctionByMember(AuctionVO obj);//mypage 나의 경매 리스트
	public int selectMemberIdByAuct(Integer auct_id);
	public ArrayList<AuctionVO> selectEndAuctionByMemberId(Map<String,Integer> obj);
	public ArrayList<AuctionVO> searchTitleOrTag(String tag);//타이틀 또는 태그 검색
	public ArrayList<AuctionVO> selectFinishedAuctIDByCurrentTime(Long current_time);
}
