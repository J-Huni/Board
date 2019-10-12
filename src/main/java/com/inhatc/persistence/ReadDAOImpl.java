package com.inhatc.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inhatc.domain.BoardVO;

@Repository
public class ReadDAOImpl implements ReadDAO{
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.js.mapper.ReadMapper";
	
	@Override
	public BoardVO readPost(Integer l_no) {
		return session.selectOne(namespace + ".readPost", l_no);
	}
	
	@Override
	public int deletePost(BoardVO vo) {
		return session.delete(namespace + ".deletePost", vo);
	}
	
	@Override
	public int editPost(BoardVO vo) {
		return session.update(namespace + ".editPost", vo);
	}
}
