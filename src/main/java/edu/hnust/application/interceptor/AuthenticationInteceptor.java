package edu.hnust.application.interceptor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import edu.hnust.application.common.util.DateUtil;

public class AuthenticationInteceptor implements HandlerInterceptor {
    
    // @Autowired
    // private UserSingleton userSingleton;
    
    public AuthenticationInteceptor() {
        
    }
    
    @Override
    public boolean preHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject)
        throws IOException {
        /*
        String lang = paramHttpServletRequest.getParameter("lang");
        if (StringUtils.isEmpty(lang)) {
            Object o = paramHttpServletRequest.getAttribute("lang");
            if (null != o) {
                lang = o.toString();
            }
        }
        if (StringUtils.isNotEmpty(lang)) {
            Locale.setDefault(new Locale(lang));
        }
        if (a(paramObject).booleanValue()) {
            return true;
        }
        String str = paramHttpServletRequest.getRequestURI().substring(paramHttpServletRequest.getContextPath().length());
        if (permissionPage(str).booleanValue()) {
            return true;
        }
        UserInfor user = userSingleton.getUserInfor();
        if (null == user) {
            String p = paramHttpServletRequest.getHeader("X-Requested-With");
            if (StringUtils.isNotEmpty(p) && p.equals("XMLHttpRequest")) {
                ServletOutputStream out = paramHttpServletResponse.getOutputStream();
                out.print("un-login");// 返回给前端页面的未登陆标识
                out.flush();
                out.close();
            } else {
                paramHttpServletResponse.sendRedirect("/loginForm");
            }
            return false;
        }
        if (str.equals("/")) {
            paramHttpServletResponse.sendRedirect("/index");
            return false;
        }
        String path = paramHttpServletRequest.getPathInfo();
        System.out.println(path);
        // 校验用户未授权的URL 不允许访问,访问后定向到主页
        return interceptTimeOut(paramHttpServletRequest, str);*/
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject, ModelAndView paramModelAndView) {
    }
    
    @Override
    public void afterCompletion(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject, Exception paramException) {
    }
    
    public Boolean permissionPage(String paramString) {
        ArrayList<String> localArrayList = new ArrayList<>();
        localArrayList.add("/index");
        localArrayList.add("/kaptcha");
        localArrayList.add("/login");
        localArrayList.add("/loginForm");
        localArrayList.add("/register");
        localArrayList.add("/registerForm");
        localArrayList.add("/logout");
        localArrayList.add("/denied");
        return Boolean.valueOf(localArrayList.contains(paramString));
    }
    
    public Boolean a(Object paramObject) {
        return Boolean.valueOf(paramObject instanceof ResourceHttpRequestHandler);
    }
    
    /**
     * 验证用户30分钟内没操作，设置超时,/user/onlineLogger会定时请求，session永远不会超时
     * 
     * @param request
     * @param path
     */
    public boolean interceptTimeOut(HttpServletRequest request, String path) {
        HttpSession session = request.getSession();
        String currentTime = DateUtil.getCurrentDateTimeAsString();
        if ("/user/onlineLogger".equals(path)) {
            String attrTime = (String)session.getAttribute("attrTime");
            if (StringUtils.isNotEmpty(attrTime)) {
                long outTime = session.getMaxInactiveInterval() * 1000;
                long intervalTime = DateUtil.calIntervalTime(currentTime, attrTime);
                if (intervalTime >= outTime) {
                    session.invalidate();
                    return false;
                }
            }
        } else {
            session.setAttribute("attrTime", currentTime);
        }
        return true;
    }
}