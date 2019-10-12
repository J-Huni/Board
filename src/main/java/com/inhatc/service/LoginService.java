package com.inhatc.service;

import com.inhatc.domain.LoginVO;

public interface LoginService {
	public int loginck(LoginVO vo);
	public int signup(LoginVO vo);
	public int id_Check(String id);
}
