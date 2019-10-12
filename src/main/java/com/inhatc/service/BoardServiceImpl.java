package com.inhatc.service;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inhatc.domain.BoardVO;
import com.inhatc.domain.Criteria;
import com.inhatc.domain.FileVO;
import com.inhatc.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> listAll() throws Exception{
		return dao.listAll();
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception{
		return dao.listCriteria(cri);
	}
	
	@Override
	public int lastPostNo(Criteria cri) throws Exception{
		return dao.lastPostNo(cri);
	}
	
	@Override
	public List<BoardVO> moreList(int cri) throws Exception{
		return dao.moreList(cri);
	}
	
	@Override
    public void createBoard(String filename) {
        dao.createBoard(filename);
    }
	
	@Override
	public int creatDetail(BoardVO vo) {
		return dao.createDetail(vo);
	}
	
	@Override
	public int uploadFile(String filename) {
		return dao.uploadFile(filename);
	}
	
	@Override
	public int getLbn() throws Exception {
		return dao.getLbn();
	}
	
	@Override
	public int getNlbn() throws Exception {
		return dao.getNlbn();
	}
	
	@Override
	public int getColum(int start, int end) {
		start -= 1;
		end -= start;
		return dao.getColum(start, end);
	}
}
