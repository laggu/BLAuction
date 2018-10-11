package com.bla.biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.frame.Biz;
import com.bla.vo.PhotoVO;

@Repository("pbiz")
public class PhotoBiz implements Biz<PhotoVO,Integer>{

	@Override
	public void register(PhotoVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(PhotoVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhotoVO get(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhotoVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
