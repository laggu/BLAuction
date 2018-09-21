package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Dao;
import vo.BiddingVO;

@Repository("bdao")
public class BiddingDao implements Dao<BiddingVO,String>{

	@Override
	public void insert(BiddingVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BiddingVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BiddingVO select(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BiddingVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
