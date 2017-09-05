package com.comic.web.security;

/****
 ****   权限限制考虑
 ****/

import java.io.IOException;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

//import com.itrip.rp.common.Constants;
//import com.itrip.rp.core.freemarker.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;



public class PermissionDirective implements TemplateDirectiveModel {

    /***
     * 权限验证
     */
    @SuppressWarnings("unchecked")     //<@perm url="/product/add"></@perm>
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        //String url = DirectiveUtils.getString("url", params);
        Subject subject = SecurityUtils.getSubject();
        boolean pass = subject.isPermitted("url"); //??(url)
        if (pass) {
            body.render(env.getOut());
        }
    }
}

