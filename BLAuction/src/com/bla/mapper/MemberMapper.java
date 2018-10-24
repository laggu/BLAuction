package com.bla.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.vo.MemberVO;

@Repository("mmapper")
public interface MemberMapper {
	public MemberVO select(Integer member_id);
	public MemberVO selectbyemail(String email);
	public ArrayList<MemberVO> selectAll();
	public void insert(MemberVO obj);
	public void update(MemberVO obj);
	public void updateScore(MemberVO obj);
/*public void updateLikes(MemberVO obj);*/
}
