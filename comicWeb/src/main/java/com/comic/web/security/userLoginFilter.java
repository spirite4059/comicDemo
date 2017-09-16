package com.comic.web.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comic.web.bean.User;
import com.comic.web.util.util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class userLoginFilter extends AccessControlFilter
{
    final static Class<userLoginFilter> CLASS = userLoginFilter.class;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override       //访问接受的时候
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) throws Exception
    {
        //通过shiro保存的数据，如果已经登录了，就通过
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        if (null != user || isLoginRequest(request, response)) {
            return Boolean.TRUE;  //
        }

        HttpServletRequest httpServletRequest 	= (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //如果是ajax的请求的话
        if (util.useAjax(httpServletRequest))
        {
            PrintWriter out = null;
            try {
                // 使用 AJAX 登录失败返回的信息
                httpServletResponse.setCharacterEncoding("UTF-8");
                out =  httpServletResponse.getWriter();
                out.println("{\"status\":false, \"msg\":\"请登录后请求\"}");
                out.flush();
                out.close();
            } catch (Exception e) {
                logger.debug("输出JSON报错");
            }finally{
                if(null != out){
                    out.flush();
                    out.close();
                }
            }
        }
        return Boolean.FALSE;  //
    }


    @Override   //代表通过后是否要自己处理,false是自己处理，true是让filter继续处理
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
        logger.debug("自己处理");
        return Boolean.FALSE;
    }
}