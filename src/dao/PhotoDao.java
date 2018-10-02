package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Dao;
import vo.PhotoVO;

@Repository("pdao")
public class PhotoDao implements Dao<PhotoVO,Integer>{

	@Override
	public void insert(PhotoVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PhotoVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
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

}
