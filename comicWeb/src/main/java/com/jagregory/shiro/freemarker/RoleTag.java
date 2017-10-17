package com.jagregory.shiro.freemarker;

import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import org.apache.shiro.env.Environment;

import java.io.IOException;
import java.util.Map;

/**
 * <p>Equivalent to {@link org.apache.shiro.web.tags.RoleTag}</p>
 */
public abstract class RoleTag extends SecureTag {
    String getName(Map params) {
        return getParam(params, "name");
    }

    @Override
    public void render(freemarker.core.Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
        boolean show = showTagBody(getName(params));
        if (show) {
            renderBody(env, body);
        }
    }

    protected abstract boolean showTagBody(String roleName);
}