package biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Biz;
import vo.AuctionVO;

@Repository("abiz")
public class AuctionBiz implements Biz<AuctionVO, String>{

	@Override
	public void register(AuctionVO t) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void modify(AuctionVO t) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public AuctionVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AuctionVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
