package com.green.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.green.user.dto.UserDto;
import com.green.user.mapper.UserMapper;

@Controller
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
    // /Users/WriteForm
	@RequestMapping("/WriteForm")
	public ModelAndView writeForm() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/write");
		mv.addObject("msg", "user");
		
		return mv;
	}
	
	// /Users/Write?userid=&passwd=&username=&email=
	@RequestMapping("/Write")
	public ModelAndView write(UserDto userdto) {
		
		//db 넘기기
		userMapper.insertUser(userdto);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");
		
		return mv;
	}
	
	// /Users/List
	@RequestMapping("/List")
	public ModelAndView list( ) {
		
		//db 넘기기
		List<UserDto> userList = userMapper.getUserList();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");
		mv.addObject("userList", userList);
		
		return mv;
	}
	
	// /Users/Delete?userid=
	@RequestMapping("/Delete")
	public ModelAndView delete(UserDto userdto) {
		
		//db 넘기기
		userMapper.deleteUser(userdto);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");
		
		return mv;
	}
	
//	// /Users/Update
//	@RequestMapping("/Update")
//	public ModelAndView update() {
//		return "";
//	}
	
} //

//@RequestMapping("/List")
//public String list(Model model) {
//	return "/user/list";
//}
//@RequestMapping("/List")
//public String list(Model model) {
//	return "redirect:/Users/List";
//}
//
//@RequestMapping("/List")
//public ModelAndView list() {
//	ModelAndView mv = new ModelAndView();
//	return mv;
//}
