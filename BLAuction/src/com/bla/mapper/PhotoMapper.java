package com.bla.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.vo.PhotoVO;

@Repository("pmapper")
public interface PhotoMapper {
	public ArrayList<PhotoVO> select(Integer auct_id);
	public void insert(PhotoVO obj);
	public void update(PhotoVO obj);
	public void delete(Integer photo_id);
}
