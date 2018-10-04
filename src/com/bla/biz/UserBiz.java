package com.bla.biz;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.frame.Biz;
import com.bla.vo.UserVO;

@Repository("ubiz")
public class UserBiz implements Biz<UserVO,Integer> {

	@Override
	public void register(UserVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(UserVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO get(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
