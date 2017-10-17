package com.comic.web.controller;

import com.comic.web.base.controller.BaseController;
import com.comic.web.bean.Resource;
import com.comic.web.bean.User;
import com.comic.web.service.ResourceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController
{
	protected Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("home")
	public String home(){
		return "/admin/login";
	}
	
	
    //登陆页面,form提交的数据
    @RequestMapping("/login")
    public String adminLogin(HttpServletRequest request,Model model)
    {
    	//如果登陆失败，从request里获取认证异常信息，shiroLoginFailture 就是 shiro异常类的全限定名
    	String exception=(String) request.getAttribute("shiroLoginFailture");
    	
    	//根据shiro返回的异常路径判断，抛出指定的异常信息
    	if(exception != null)
    	{
    		if(UnknownAccountException.class.getName().equals(exception))
    		{
    			model.addAttribute("error","账号不存在");
    		}else if(IncorrectCredentialsException.class.getName().equals(exception)) {
				model.addAttribute("error", "用户名/密码错误");
			} else {
				model.addAttribute("error", "未知错误");
			}
    	}
    	
    	//成功的话，直接在表单拦截器的时候，就跳转到index去了
    	return "/admin/login";
    }
    
    
    //登陆成功，从表单 filter 跳转到这里来登陆
    @RequestMapping("/index")
    public String adminIndex() throws Exception	//??扔出exception 是什么意思呢?? 
    {	
    	//路径指到这里，也被拦截去做验证了
    	//登陆成功的话，realm里面会保存一些内容
    	HttpSession session = this.getSession();
    	
    	Subject subject= SecurityUtils.getSubject();
    	User user = (User) subject.getPrincipal();		//在realm里面设置的 ？？原来是一个对象
    	
		session.setAttribute("loginUser", user);
		
		logger.debug("输出："+session.getAttribute("loginUser").toString());
    	
		//realm里面也做了处理
		if(session.getAttribute("resources")==null)
		{	
			logger.debug("index里面,session没做好资源处理");
			//可以直接返回数量就好了;主要还是realm里面已经有了
			List<Resource> resourceList = resourceService.getUserResourceList(user.getId());
			if(resourceList.size()>0)
			{	//表示有访问的资源
				session.setAttribute("permisstion", resourceList);
				//这个地方为什么换成了menu来处理呢？
				Collection<Resource> resources = resourceService.getUserMenuResourceList(user.getId());
				session.setAttribute("resources", resources);
			}
		}
    	return "/admin/index";
    }
    
}




