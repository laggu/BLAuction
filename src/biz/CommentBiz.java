package biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Biz;
import vo.CommentVO;

@Repository("cbiz")
public class CommentBiz implements Biz<CommentVO,String>{

	@Override
	public void register(CommentVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(CommentVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommentVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CommentVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
