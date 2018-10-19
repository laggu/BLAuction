package com.bla.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bla.dao.SuccessfulBidDao;
import com.bla.frame.Biz;
import com.bla.vo.SuccessfulBidVO;

@Service("sbiz")
public class SuccessfulBidBiz implements Biz<SuccessfulBidVO,Integer>{

	@Resource(name = "sdao")
	SuccessfulBidDao sdao;
	
	@Override
	public void register(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		sdao.insert(t);
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

	public ArrayList<SuccessfulBidVO> selectMySuccessfulBid(Integer member_id) throws Exception{
		return sdao.selectMySuccessfulBid(member_id);
	}
	
	public SuccessfulBidVO oneSelectMySuccessfulBid(Integer auct_id) throws Exception{
		return sdao.oneSelectMySuccessfulBid(auct_id);
	}
}
