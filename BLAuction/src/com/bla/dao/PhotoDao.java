package com.bla.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bla.frame.Dao;
import com.bla.mapper.PhotoMapper;
import com.bla.vo.PhotoVO;

@Repository("pdao")
public class PhotoDao implements Dao<PhotoVO,Integer>{
	
	@Resource(name="pmapper")
	PhotoMapper pmapper;

	@Override
	public void insert(PhotoVO t) throws Exception {
		// TODO Auto-generated method stub
		pmapper.insert(t);
	}

	@Override
	public void update(PhotoVO t) throws Exception {
		// TODO Auto-generated method stub
		pmapper.update(t);
	}

	@Override
	public void delete(Integer v) throws Exception {
		// TODO Auto-generated method stub
		pmapper.delete(v);
	}

	@Override
	public PhotoVO select(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhotoVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PhotoVO> selectAll(Integer auct_id) throws Exception{
		return pmapper.select(auct_id);
	}
	
	public Integer selectPhotoId(PhotoVO obj) throws Exception{
		return pmapper.selectPhotoId(obj);
	}
}
