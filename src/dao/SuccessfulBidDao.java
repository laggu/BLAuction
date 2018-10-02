package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Dao;
import vo.SuccessfulBidVO;

@Repository("sdao")
public class SuccessfulBidDao implements Dao<SuccessfulBidVO,String>{

	@Override
	public void insert(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SuccessfulBidVO select(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SuccessfulBidVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
