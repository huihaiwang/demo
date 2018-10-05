package com.demo.ssm.controller;

import com.demo.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.ssm.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private IUserService userService;

	
	//url:user/showUser
	@RequestMapping("showUser")
	public String toUser(@RequestParam("id")Long id,Model model){
		
		User user = userService.findUserById(id);
		
		model.addAttribute("user", user);
		 
		return "user";
	}
	
	
	
	
}
