package com.inhatc.persistence;

import java.util.HashMap;
import java.util.List;

import com.inhatc.domain.BoardVO;
import com.inhatc.domain.Criteria;

public interface BoardDAO {
	public List<BoardVO> listAll() throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	public int lastPostNo(Criteria cri) throws Exception;
	public List<BoardVO> moreList(int cri) throws Exception;
	public void createBoard(String filename);
	public int createDetail(BoardVO vo);
	public int uploadFile(String filename);
	public int getLbn() throws Exception;
	public int getNlbn() throws Exception;
	public int getColum(int start, int end);
}
