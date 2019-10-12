package com.inhatc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inhatc.domain.BoardVO;
import com.inhatc.service.ReadService;

@Controller
public class ReadController {
	@Autowired
	private ReadService service;
	
	
	@RequestMapping(value = "/post/readPost", method = RequestMethod.GET)
	public void readPost(@RequestParam("l_no") int l_no, Model model) {
		model.addAttribute("read", service.readPost(l_no));
	}
	
	@RequestMapping(value = "/post/deletePost", method = RequestMethod.POST)
	public String deletePost(BoardVO vo, Model model) {
		service.deletePost(vo);
		return "/board/BoardMain";
	}
	
	@RequestMapping(value = "/post/editPost", method = RequestMethod.GET)
	public void editPost(@RequestParam("l_no") int l_no, Model model) {
		model.addAttribute("read", service.readPost(l_no));
	}
	
	@RequestMapping(value = "/post/editPost", method = RequestMethod.POST)
	public @ResponseBody Object editResult(BoardVO vo) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		int result = service.editPost(vo);
		System.out.println(result);
		if(result == 0) {
			paramMap.put("result", "fail");
			return paramMap;
		}
		else {
			paramMap.put("result", "success");
			return paramMap;
		}  
	}
}
