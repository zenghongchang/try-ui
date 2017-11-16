package edu.hnust.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import edu.hnust.common.utils.crypto.MD5Coding;
import edu.hnust.controller.base.BaseController;
import edu.hnust.core.UserSingleton;
import edu.hnust.dto.user.UserInfor;
import edu.hnust.orm.user.User;
import edu.hnust.orm.user.UserLoginLog;
import edu.hnust.service.user.IUserLoginLogService;
import edu.hnust.service.user.IUserService;
import edu.hnust.util.DateUtil;
import edu.hnust.util.MyLocale;
import edu.hnust.util.RequestUtil;
import edu.hnust.util.SimpleKaptcha;

@Scope("prototype")
@RequestMapping("/")
@Controller
public class AuthenticateController extends BaseController {
    
    @Autowired
    private IUserService userService;     
    @Autowired
    private UserSingleton userSingleton;    
    @Autowired
    private IUserLoginLogService loginLogService;    
    
    /**
     * 主页面
     * 
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        // return "index";
        return "laboratory";
    }
    
    /**
     * 登录页面
     * 
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginForm")
    public String loginForm(Model model, HttpServletRequest request) {
        model.addAttribute("lang", "cn");
        UserInfor userInfo = userSingleton.getUserInfor();
        if (null != userInfo) {
            return "redirect:/index";
        }        
        return "admin/login";
    }
    
    @RequestMapping(value = "/loginDemo")
    public String loginDemo(Model model, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request) {
        System.out.println(request.getAttribute("username"));
        System.out.println(request.getAttribute("password"));
        System.out.println(username);
        System.out.println(password);
        return "page/error";
    }
    
    
    /**
     * 登录
     *
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(User user, RedirectAttributes attributes, @RequestParam("kaptcha") String kaptcha, HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        String loginName = user.getLoginName();
        String password = user.getPassword();
        String language = user.getLanguage();
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password) || StringUtils.isBlank(language) || StringUtils.isBlank(kaptcha)) {
            return "redirect:/loginForm";
        }
        attributes.addFlashAttribute("loginName", loginName);
        attributes.addFlashAttribute("password", password);
        attributes.addFlashAttribute("kaptcha", kaptcha);
        HttpSession session = request.getSession();
        String kaptchaStr = (String)session.getAttribute(SimpleKaptcha.KAPTCHA_CODE_IN_SESSION);
        System.out.println("kaptchaStr = " + kaptchaStr + "      kaptcha = " + kaptcha);
        if (null != kaptcha) {
            if (StringUtils.isBlank(kaptchaStr) || !kaptcha.toLowerCase().equals(kaptchaStr.toLowerCase())) {
                attributes.addFlashAttribute("authCodeError", new MyLocale(language).getText("verification.code.error"));
                return "redirect:/loginForm";
            }
        }
        // 多语言处理，主要是处理freemarker中的<@spring.massege "" >
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }
        LocaleEditor localeEditor = new LocaleEditor();
        localeEditor.setAsText(language);
        localeResolver.setLocale(request, response, (Locale)localeEditor.getValue());
        // 校验登录名是否存在
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName", loginName);
        // 校验登录名及密码是否存在
        user.setPassword(MD5Coding.encode2HexStr(password.getBytes()));
        User resultUser = userService.login(user);
        if (resultUser == null) {
            log.info("request:login fail");
        }
        log.info("request: user/login , user: " + user.toString());
        if (resultUser == null) {
            attributes.addFlashAttribute("passError", new MyLocale(language).getText("password.error"));
            return "redirect:/loginForm";
        }
        resultUser.setLanguage(language);
        resultUser.setRemoteAddr(RequestUtil.getIP(request));
        createLoginLog(resultUser, request);
        this.initUserInfor(resultUser);
        return "redirect:/index";
        
    }
    
    private void initUserInfor(User resultUser) {
    }
    
    private void createLoginLog(User user, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String userAgent = RequestUtil.getUserAgent(request);
            String ipAddress = RequestUtil.getIP(request);
            String loginAddress = request.getServerName();
            String currentTime = DateUtil.getCurrentDateTimeAsString();
            UserLoginLog log = new UserLoginLog();
            log.setUserId(user.getId());
            log.setIpAddress(ipAddress);
            log.setUserAgent(userAgent);
            log.setLoginAddress(loginAddress);
            log.setLoginName(user.getUserName());
            log.setLoginTime(currentTime);
            Long logId = loginLogService.createLog(log);
            session.setAttribute("login-log-id", logId);
            session.setAttribute("recordTime", currentTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 退出系统
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session)
        throws Exception {
        String sessionId = session.getId();
        loginLogService.cleanRecordTimeBySessionId(sessionId);
        session.invalidate();
        log.info("request: user/logout");
        return "redirect:/loginForm";
    }
    
    /**
     * 前端请求用户超时,不跳转页面
     * 
     * @param session
     * @throws Exception
     */
    @RequestMapping("/overTimeLogout")
    @ResponseBody
    public void overTimeLogout(HttpSession session)
        throws Exception {
        String sessionId = session.getId();
        loginLogService.cleanRecordTimeBySessionId(sessionId);
        session.invalidate();
    }
    
    @RequestMapping("/kaptcha")
    public void createKaptcha(HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);        
        try {
            String kaptcha = SimpleKaptcha.create(120, 30, 4, 20, 16, 6, 5, response.getOutputStream());
            request.getSession().setAttribute(SimpleKaptcha.KAPTCHA_CODE_IN_SESSION, kaptcha);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}