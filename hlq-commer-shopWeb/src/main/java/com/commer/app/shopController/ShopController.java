package com.commer.app.shopController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.commer.app.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.commer.app.UserService.UserService;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Resource
	private UserService userService;


	@RequestMapping("/index")
	public String index() {
		System.out.print(userService.selectByPrimaryKey(1));

		return "test";
	}
}
