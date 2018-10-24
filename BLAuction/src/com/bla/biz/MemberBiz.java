package com.bla.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bla.dao.MemberDao;
import com.bla.frame.Biz;
import com.bla.frame.Dao;
import com.bla.vo.MemberVO;

@Repository("mbiz")
public class MemberBiz implements Biz<MemberVO,Integer> {
	
	@Resource(name = "mdao")
	MemberDao dao;

	@Override
	public void register(MemberVO t) throws Exception {
		dao.insert(t);
	}

	@Override
	public void modify(MemberVO t) throws Exception {
		dao.update(t);
	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO get(Integer v) throws Exception {
		return dao.select(v);
	}//member_id
	
	public MemberVO get(String v) throws Exception {
		return dao.select(v);
	}//email 

	@Override
	public ArrayList<MemberVO> get() throws Exception {
		return dao.select();
	}


}
