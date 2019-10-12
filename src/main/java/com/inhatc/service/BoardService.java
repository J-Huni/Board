package com.inhatc.service;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;

import com.inhatc.domain.BoardVO;
import com.inhatc.domain.Criteria;
import com.inhatc.domain.FileVO;

public interface BoardService {
	public List<BoardVO> listAll() throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	public int lastPostNo(Criteria cri) throws Exception;
	public List<BoardVO> moreList(int cri) throws Exception;
	public void createBoard(String filename);
	public int creatDetail(BoardVO vo);
	public int uploadFile(String filename);
	public int getLbn() throws Exception;
	public int getNlbn() throws Exception;
	public int getColum(int start, int end);
}
