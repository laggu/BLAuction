package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Dao;
import vo.DeliveryVO;

@Repository("ddao")
public class DeliveryDao implements Dao<DeliveryVO,String>{

	@Override
	public void insert(DeliveryVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DeliveryVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DeliveryVO select(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliveryVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
