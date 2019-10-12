package com.inhatc.persistence;

import com.inhatc.domain.LoginVO;

public interface LoginDAO {
	public int loginck(LoginVO vo);
	public int signup(LoginVO vo);
	public int id_Check(String id);
}
