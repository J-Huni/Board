package com.inhatc.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inhatc.domain.BoardVO;
import com.inhatc.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.js.mapper.BoardMapper";
	
	@Override
	public List<BoardVO> listAll() throws Exception{
		return session.selectList(namespace+".listAll");
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception{
		return session.selectList(namespace+".listCri", cri);
	}
	
	@Override
	public int lastPostNo(Criteria cri) throws Exception{
		return session.selectOne(namespace+".lastPostNo", cri);
	}
	
	@Override
	public List<BoardVO> moreList(int cri) throws Exception{
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		int cri2 = cri - 8;
		paramMap.put("cri2", cri2);
		paramMap.put("cri", cri);
		return session.selectList(namespace+".moreList", paramMap);
	}
	
	@Override
	public void createBoard(String filename){
		session.insert(namespace + ".CreateBoard", filename);
	}
	
	@Override
	public int createDetail(BoardVO vo) {
		return session.update(namespace + ".createDetail", vo);
	}
	
	@Override
	public int uploadFile(String filename) {
		return session.insert(namespace + ".uploadFile", filename);
	}
	
	@Override
	public int getLbn() throws Exception{
		return session.selectOne(namespace+".getLbn");
	}
	
	@Override
	public int getNlbn() throws Exception{
		return session.selectOne(namespace+".getNlbn");
	}
	
	@Override
	public int getColum(int start, int end) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startNo", start);
		paramMap.put("endNo", end);
		return session.update(namespace+".getColum", paramMap);
	}
}
