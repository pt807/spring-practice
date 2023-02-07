package com.douzone.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileuploadController {

	@RequestMapping({ "", "/form" })
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}

	@RequestMapping("upload")
	public String upload(
			@RequestParam("email") String email, 
			@RequestParam("file") MultipartFile file) {
		
		String url = fileuploadservice.restore(file);
		return "WEB-INF/views/result.jsp";
	}
}
