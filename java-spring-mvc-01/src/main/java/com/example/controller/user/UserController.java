package com.example.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String goToRegister() {
		return "user/userRegister";
	}
	
	@RequestMapping(value="/reissue", method=RequestMethod.GET)
	public String goToReissue() {
		return "user/reissuePassword";
	}
}
