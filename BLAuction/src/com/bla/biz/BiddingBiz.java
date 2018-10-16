package com.bla.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bla.dao.BiddingDao;
import com.bla.frame.Biz;
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
		return null;
	}

	@Override
	public ArrayList<BiddingVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Integer> selectAuctIdByMemberId(Integer member_id) throws Exception{
		return bdao.selectAuctIdByMemberId(member_id);
	}
}
