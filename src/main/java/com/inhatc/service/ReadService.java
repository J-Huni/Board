package com.inhatc.service;

import java.util.List;

import com.inhatc.domain.BoardVO;

public interface ReadService {
	public BoardVO readPost(Integer l_no);
	public int deletePost(BoardVO vo);
	public int editPost(BoardVO vo);
}
