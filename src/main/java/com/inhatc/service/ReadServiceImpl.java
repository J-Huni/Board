package com.inhatc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inhatc.domain.BoardVO;
import com.inhatc.persistence.ReadDAO;

@Service
public class ReadServiceImpl implements ReadService{
	@Autowired
	private ReadDAO dao;
	
	@Override
	public BoardVO readPost(Integer l_no) {
		return dao.readPost(l_no);
	}
	
	@Override
	public int deletePost(BoardVO vo) {
		return dao.deletePost(vo);
	}
	
	@Override
	public int editPost(BoardVO vo) {
		return dao.editPost(vo);
	}
}
