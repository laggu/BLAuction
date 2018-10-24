package com.bla.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bla.frame.Dao;
import com.bla.mapper.MemberMapper;
import com.bla.vo.MemberVO;

@Repository("mdao")
public class MemberDao implements Dao<MemberVO,Integer> {
	
	/*@Resource(name="mmapper")
	MemberMapper mmapper;
*/
	@Autowired
	MemberMapper mapper;
	
	@Override
	public void insert(MemberVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(MemberVO t) throws Exception {
		mapper.update(t);
		
	}

	@Override
	public void delete(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO select(Integer v) throws Exception {
		return mapper.select(v);
	}//member_id

	public MemberVO select(String v) throws Exception {
		return mapper.selectbyemail(v);
	}//email
	
	@Override
	public ArrayList<MemberVO> select() throws Exception {
		return mapper.selectAll();
	}

}
