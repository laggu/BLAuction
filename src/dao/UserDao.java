package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Dao;
import vo.UserVO;

@Repository("udao")
public class UserDao implements Dao<UserVO,Integer> {

	@Override
	public void insert(UserVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO select(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
