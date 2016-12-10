package com.comic.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShowController {
	
	@RequestMapping("/show")
	public String show()
	{
		System.out.println("show");
		return "/show";
	}
	
    @RequestMapping("/index1")   
    public String index1()
    {
    	System.out.println("index1");
        return "/index1";
    }
}
