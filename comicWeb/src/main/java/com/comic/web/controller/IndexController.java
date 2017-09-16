package com.comic.web.controller;

import com.comic.web.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController
{

    @RequestMapping("/index")   
    public String index()
    {
    	System.out.println("这块执行了么");
        return "/web/publicCai";
    }

    @RequestMapping("/wokao/test")
    public void test()
    {
        System.out.println("wokaolewokao");
        
    }

    
    @RequestMapping("/admin/up_index_img")   
    public String up_index_img()
    {
    	System.out.println("请求 up_index_img");
        return "/admin/up_index_img";
    }
}