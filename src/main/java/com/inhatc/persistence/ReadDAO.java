package com.inhatc.persistence;

import com.inhatc.domain.BoardVO;

public interface ReadDAO {
	public BoardVO readPost(Integer l_no);
	public int deletePost(BoardVO vo);
	public int editPost(BoardVO vo);
}
