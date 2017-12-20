package com.commer.shopController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
