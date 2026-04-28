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
		
		// 넘어온 data db에 저장
		userMapper.insertUser(userdto);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");
		
		return mv;
	}
	
	// /Users/List
	@RequestMapping("/List")
	public ModelAndView list( ) {
		
		List<UserDto> userList = userMapper.getUserList();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/list");
		mv.addObject("userList", userList);
		
		return mv;
	}
	
	// /Users/Delete
	@RequestMapping("/Delete")
	public ModelAndView delet(UserDto userdto) {
		
		userMapper.DeleteUser(userdto);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");
		
		return mv;
	}
	
}
