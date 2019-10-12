package com.inhatc.persistence;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inhatc.domain.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	@Autowired
	private SqlSession session;
	private static String namespace = "com.js.mapper.LoginMapper";
	
	@Override
	public int loginck(LoginVO vo) {
		return session.selectOne(namespace+".login_ck",vo);
	}
	
	@Override
	public int signup(LoginVO vo) {
		return session.insert(namespace+".signup", vo);
	}
	
	@Override
	public int id_Check(String id){
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id",id);
		int result = session.selectOne(namespace+".id_Check",paramMap);
		if (result == 1){
			return 1;
		}
		else {
			return 0;
		}
	}
}
