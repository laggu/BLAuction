package biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Biz;
import vo.TagVO;

@Repository("tbiz")
public class TagBiz implements Biz<TagVO,Integer> {

	@Override
	public void register(TagVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(TagVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TagVO get(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TagVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
