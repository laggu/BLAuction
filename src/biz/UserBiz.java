package biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import frame.Biz;
import vo.UserVO;

@Repository("ubiz")
public class UserBiz implements Biz<UserVO,String> {

	@Override
	public void register(UserVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(UserVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
