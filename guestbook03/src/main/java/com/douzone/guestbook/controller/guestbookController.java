package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class guestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;

	@RequestMapping("/")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "WEB-INF/views/index.jsp";
	}

	@RequestMapping("/add")
	public String add(GuestbookVo guestbookVo) {
		guestbookRepository.insert(guestbookVo);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteForm(@RequestParam Long no, Model mode) {
		mode.addAttribute("no", no);
		return "WEB-INF/views/deleteform.jsp";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("no") Long no, @RequestParam("password") String password) {
		guestbookRepository.deleteByPassword(password, no);
		return "redirect:/";
	}
}
