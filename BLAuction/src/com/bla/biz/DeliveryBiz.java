package com.bla.biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.frame.Biz;
import com.bla.vo.DeliveryVO;

@Repository("dbiz")
public class DeliveryBiz  implements Biz<DeliveryVO,String>{

	@Override
	public void register(DeliveryVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(DeliveryVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DeliveryVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliveryVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
