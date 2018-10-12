package com.bla.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.vo.AuctionVO;

@Repository("amapper")
public interface AuctionMapper {
	public AuctionVO select(Integer id);
	public ArrayList<AuctionVO> selectAll();
	public void insert(AuctionVO obj);
	public void insertDown(AuctionVO obj);
	public void updateStatus(AuctionVO obj);
	public void updateTag(AuctionVO obj);
}
