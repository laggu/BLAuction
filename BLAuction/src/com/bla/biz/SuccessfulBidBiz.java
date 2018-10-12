package com.bla.biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.frame.Biz;
import com.bla.vo.SuccessfulBidVO;

@Repository("sbiz")
public class SuccessfulBidBiz implements Biz<SuccessfulBidVO,Integer>{

	@Override
	public void register(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SuccessfulBidVO get(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SuccessfulBidVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
