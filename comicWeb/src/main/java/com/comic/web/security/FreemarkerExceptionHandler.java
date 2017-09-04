package com.comic.web.security;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Writer;

/*******************
 * freeMark 异常处理：
 * 1、在 freemark config里面配置 <prop key = "template_exception_handler">com.persia.exception.FreemarkerExceptionHandler</prop>
 * 2、写该异常
 * 3、抛出viewException给视图类
*******************/
public class FreemarkerExceptionHandler implements TemplateExceptionHandler 
{
    private  Logger log = LoggerFactory.getLogger(this.getClass());

    public void handleTemplateException(TemplateException te, 
    									Environment env,
    									Writer out) throws TemplateException 
    {

        log.warn("[捕捉freemark错误: " + te.getMessage() + "]");
        //throw new TemplateException("freeMark error:"+te,env);
	}
}






