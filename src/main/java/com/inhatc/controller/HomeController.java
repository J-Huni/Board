package com.inhatc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inhatc.domain.LoginVO;
import com.inhatc.service.LoginService;

@Controller
public class HomeController {
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginVO vo, HttpSession session) {
		int result = service.loginck(vo);
		System.out.println(result);
		if (result == 1) {
			session.setAttribute("id", vo.getId());
			return "redirect:board/ImgMain";
		}
		else {
			return "fail";
		}
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(LoginVO vo, Model model) {
		int result = service.signup(vo);
		System.out.println(vo.getName());
		if (result == 1) {
			return "redirect:/";
		}
		else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/id_Check", method = RequestMethod.POST)
	public @ResponseBody Object idCheck(LoginVO vo) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		int result = service.id_Check(vo.getId());
		System.out.println(result);
		if(result == 0) {
			paramMap.put("result", "success");
			return paramMap;
		}
		else {
			paramMap.put("result", "deny");
			return paramMap;
		}
		
	}
}
