package com.bla.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bla.frame.Dao;
import com.bla.mapper.SuccessfulBidMapper;
import com.bla.vo.SuccessfulBidVO;

@Repository("sdao")
public class SuccessfulBidDao implements Dao<SuccessfulBidVO, Integer> {

	@Autowired
	SuccessfulBidMapper smapper;

	@Override
	public void insert(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		smapper.insert(t);
	}

	@Override
	public void update(SuccessfulBidVO t) throws Exception {
		// TODO Auto-generated method stub
		smapper.update(t);

	}

	@Override
	public void delete(Integer v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public SuccessfulBidVO select(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SuccessfulBidVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SuccessfulBidVO> selectMySuccessfulBid(Integer member_id) throws Exception {
		return smapper.selectMySuccessfulBid(member_id);
	}

	public SuccessfulBidVO oneSelectMySuccessfulBid(Integer auct_id) throws Exception {
		return smapper.oneSelectMySuccessfulBid(auct_id);
	}
	
	public void updateReview(SuccessfulBidVO obj) throws Exception {
		smapper.updateReview(obj);
	}
}
