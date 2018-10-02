package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Dao;
import vo.AuctionVO;

@Repository("adao")
public class AuctionDao implements Dao<AuctionVO, Integer>{

	@Override
	public void insert(AuctionVO t) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(AuctionVO t) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Integer v) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public AuctionVO select(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AuctionVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
