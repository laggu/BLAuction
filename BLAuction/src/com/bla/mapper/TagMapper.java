package com.bla.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bla.vo.TagVO;

@Repository("tmapper")
public interface TagMapper {
	public ArrayList<TagVO> select(Integer auct_id);
	public void insert(TagVO obj);
	public void update(TagVO obj);
	public void delete(Integer tag_id);
}
