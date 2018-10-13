package com.bla.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bla.dao.PhotoDao;
import com.bla.frame.Biz;
import com.bla.vo.PhotoVO;

@Repository("pbiz")
public class PhotoBiz implements Biz<PhotoVO,Integer>{
	
	@Resource(name="pdao")
	PhotoDao pdao;

	@Override
	public void register(PhotoVO t) throws Exception {
		// TODO Auto-generated method stub
		pdao.insert(t);
	}

	@Override
	public void modify(PhotoVO t) throws Exception {
		// TODO Auto-generated method stub
		pdao.update(t);
	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
		pdao.delete(v);
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
	
	public ArrayList<PhotoVO> getAll(Integer auct_id) throws Exception{
		return pdao.selectAll(auct_id);
	}
	
	public Integer getPhotoId(PhotoVO obj) throws Exception{
		return pdao.selectPhotoId(obj);
	}

}
