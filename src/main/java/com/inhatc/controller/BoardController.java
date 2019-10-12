package com.inhatc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.inhatc.domain.BoardVO;
import com.inhatc.domain.Criteria;
import com.inhatc.service.BoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/board/BoardMain", method = RequestMethod.GET)
	public void BoardMain() {
		
	}
	
	@RequestMapping(value = "/board/SelectBoard", method = RequestMethod.GET)
	public void SelectBoard(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("BoardList", service.listCriteria(cri));
		model.addAttribute("lpn", service.lastPostNo(cri));
		/*System.out.println(service.lastPostNo(cri));*/
		/*model.addAttribute("BoardList", service.listAll());*/
	}
	
	@RequestMapping(value = "/board/FreeBoard", method = RequestMethod.GET)
	public void FreeBoard() {
		
	}
	
	@RequestMapping(value = "/board/CreateLiBoard", method = RequestMethod.GET)
	public void CreateBoard(HttpSession session, Model model) {
		if(session.getAttribute("id") != null) {
			model.addAttribute("session", "yes");
		}
	}
	
	@RequestMapping(value = "/MoreList", method = RequestMethod.POST)
	public @ResponseBody List<BoardVO> MoreList(@RequestParam("pagePost") int pagePost) throws Exception {
/*		ModelAndView mv = new ModelAndView();
		mv.addObject("BoardList", service.moreList(pagePost));*/
		List<BoardVO> list = service.moreList(pagePost); 
		return list;
	}
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public @ResponseBody Object uloadFile(Model model, HttpSession session, MultipartFile file) throws Exception{
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if(file.getSize() == 0) {
			paramMap.put("emptyfile", 0);
			return paramMap;
		}
		else {
			logger.info("filename : "+file.getOriginalFilename());
			logger.info("filesize : "+file.getSize());
			logger.info("filetype : "+file.getContentType());
			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
			model.addAttribute("savedName", savedName);
			service.createBoard(savedName);
			paramMap.put("name", savedName);
			return paramMap;
		}
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_"+ originalName;
		
		File target = new File(uploadPath, savedName);
		
		FileCopyUtils.copy(fileData,  target);
		
		return savedName;
	}
	
	@RequestMapping(value = "/board/CreateLiBoard", method = RequestMethod.POST)
	public void createDetail(BoardVO vo) {
		System.out.println(service.creatDetail(vo));
	}
	
	@RequestMapping(value = "/board/ImgMain", method = RequestMethod.GET)
	public void ImgMain() {
		
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(MultipartHttpServletRequest mtfRequest, ModelAndView mv) throws Exception {
        List<MultipartFile> fileList = mtfRequest.getFiles("file");
        String src = mtfRequest.getParameter("src");
        System.out.println("src value : " + src);
        
        String path = "C:\\Users\\bioro\\Desktop\\W\\project\\seven_group\\src\\main\\webapp\\resources\\img\\selectImg";

        for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);

            String safeFile = System.currentTimeMillis() + originFileName;
            service.uploadFile(safeFile);
            
    		File target = new File(path, safeFile);
    		try {
				FileCopyUtils.copy(mf.getBytes(),  target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.println(service.getNlbn());
        System.out.println(service.getLbn());
		mv.addObject("start", service.getNlbn());
        mv.addObject("end", service.getLbn());
        return "redirect:/";
    }
}
