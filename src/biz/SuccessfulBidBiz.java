package biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Biz;
import vo.SuccessfulBidVO;

@Repository("sbiz")
public class SuccessfulBidBiz implements Biz<SuccessfulBidVO,String>{

	@Override
	public void register(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SuccessfulBidVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SuccessfulBidVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
