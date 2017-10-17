package com.comic.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class ProductController 
{
	@RequestMapping("/product_list")
	public String show()
	{
		System.out.println("show");
		return "/web/product_list";
	}

	@RequestMapping("/product_search")   
	public String index1()
	{
		System.out.println("index1");
	    return "/product_search";
	}
}


