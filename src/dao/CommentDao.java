package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Dao;
import vo.CommentVO;

@Repository("cdao")
public class CommentDao implements Dao<CommentVO,String>{

	@Override
	public void insert(CommentVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CommentVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommentVO select(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CommentVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
