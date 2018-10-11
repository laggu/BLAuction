package com.bla.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.frame.Dao;
import com.bla.vo.TagVO;

@Repository("tdao")
public class TagDao implements Dao<TagVO,Integer>{

	@Override
	public void insert(TagVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TagVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TagVO select(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TagVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
