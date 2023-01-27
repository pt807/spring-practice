package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequestMapping 클래스 + 메소드 매핑
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required = true, defaultValue = "1") int pageNo) {
		return "UserController.list(" + pageNo + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam(value="n") String name) {
		/**
		 * 만일 n이라는 이름의 url 파라미터가 없으면
		 * 400 bad request 에러가 발생한다
		 */
		return "UserController.list(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required = true, defaultValue = "gil") String name) {
		
		return "UserController.list(" + name + ")";
	}
}
