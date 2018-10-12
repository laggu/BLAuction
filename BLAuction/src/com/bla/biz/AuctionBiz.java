package com.bla.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bla.frame.Biz;
import com.bla.frame.Dao;
import com.bla.vo.AuctionVO;

@Repository("abiz")
public class AuctionBiz implements Biz<AuctionVO, Integer>{

	@Resource(name="adao")
	Dao<AuctionVO, Integer> adao;
	
	@Override
	public void register(AuctionVO t) throws Exception {
		adao.insert(t);
	}

	@Override
	public void modify(AuctionVO t) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public AuctionVO get(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AuctionVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
