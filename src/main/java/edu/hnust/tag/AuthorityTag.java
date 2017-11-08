package edu.hnust.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.hnust.core.UserSingleton;
import edu.hnust.dto.user.GroupInfo;
import edu.hnust.dto.user.UserInfor;
import edu.hnust.service.user.IUserService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

@Component("auth")
public class AuthorityTag implements TemplateDirectiveModel {
    @Autowired
    private UserSingleton userSingleton;    
    @Resource
    private IUserService userService;
    
    @SuppressWarnings("rawtypes")
    @Override
    public void execute(Environment paramEnvironment, Map paramMap, TemplateModel[] paramArrayOfTemplateModel, TemplateDirectiveBody paramTemplateDirectiveBody)
        throws TemplateException, IOException {
        boolean show = checkAuth(paramEnvironment, paramMap, paramTemplateDirectiveBody);
        // 3.无权限的话 页面不展示
        if (show) {
            paramTemplateDirectiveBody.render(paramEnvironment.getOut()); // 最后使用body.render(env.getOut())将数据交给模版页面
        }
    }
    
    @SuppressWarnings("rawtypes")
    public boolean checkAuth(Environment paramEnvironment, Map paramMap, TemplateDirectiveBody paramTemplateDirectiveBody)
        throws TemplateModelException, TemplateException, IOException {
        // 1.session 或者 缓存输出 当前用户查询的按钮或者页面权限
        boolean show = false;
        UserInfor user = userSingleton.getUserInfor();
        if (null != user.getUser().getIsSuperUser() && user.getUser().getIsSuperUser().intValue() == 1) {// 超接管理员不需要判断权限
            return !show;
        }
        List<GroupInfo> groups = user.getGroups();
        // Dumper.dump(groups);
        if (CollectionUtils.isEmpty(groups)) {
            return show;
        }
        TemplateModel methodModel = (TemplateModel)paramMap.get("name");
        System.out.println();
        String method = "";
        if (methodModel instanceof TemplateScalarModel) {
            method = ((SimpleScalar)methodModel).getAsString();
        }
        String[] methodsList = method.split("\\,");
        if (ArrayUtils.isEmpty(methodsList)) {
            return show;
        }
        for (String me : methodsList) {
            if (user.getMenuUrlPermissions().containsKey(me)) {
                show = true;
                break;
            }
            if (user.getAclUrlPermissions().containsKey(me)) {
                show = true;
                break;
            }
        }
        return show;
    }
    
    public static BeansWrapper getBeansWrapper() {
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_23).build();
        return beansWrapper;
    }
}