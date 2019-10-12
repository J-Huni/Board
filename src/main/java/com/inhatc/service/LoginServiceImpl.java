package com.inhatc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inhatc.domain.LoginVO;
import com.inhatc.persistence.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {
		@Autowired
		private LoginDAO dao;
	
		@Override
		public int loginck(LoginVO vo){
			return dao.loginck(vo);
		}
		
		@Override
		public int signup(LoginVO vo) {
			return dao.signup(vo);
		}
		
		@Override
		public int id_Check(String id) {
			return dao.id_Check(id);
		}
}