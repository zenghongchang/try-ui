package edu.hnust.application.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import edu.hnust.application.common.crypto.MD5Coding;
import edu.hnust.application.common.util.DateUtil;
import edu.hnust.application.common.util.MyLocale;
import edu.hnust.application.common.util.RequestUtil;
import edu.hnust.application.common.util.SimpleKaptcha;
import edu.hnust.application.controller.base.BaseController;
import edu.hnust.application.core.UserSingleton;
import edu.hnust.application.core.system.StandardPageUtil;
import edu.hnust.application.orm.user.User;
import edu.hnust.application.orm.user.UserLoginLog;
import edu.hnust.application.service.user.IUserLoginLogService;
import edu.hnust.application.service.user.IUserService;

/**
 * 
 * @author Henry(fba02)
 * @version [版本号, 2017年11月16日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Scope("prototype")
@RequestMapping("/")
@Controller
public class AuthenticateController extends BaseController {
    @Autowired
    private StandardPageUtil standardPageUtil;
    @Autowired
    private IUserService userService;    
    @Autowired
    private UserSingleton userSingleton;    
    @Autowired
    private IUserLoginLogService loginLogService;
    public static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";      
    public static String KAPTCHA_CODE_IN_SESSION = "kaptcha_code_in_session";
    private static final String ADMIN_LOGIN_FORM = "management/admin_login";
    
    /**
     * 主页面
     * 
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "management/admin_login";
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
        User userInfo = userSingleton.getUser();
        if (null != userInfo) {
            return "redirect:/index";
        }
        return "admin/login";
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
    
    /**
     * 获取验证码
     * 
     * @param response
     * @param request
     * @throws IOException
     * @author Henry(fba02)
     * @version [版本号, 2017年11月17日]
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/kaptcha", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> createKaptcha(HttpServletResponse response, HttpServletRequest request) {
        Random random = new Random();
        Map<String, String> result = new HashMap<String, String>();
        String strCode = "";
        for (int i = 0; i < 4; i++) {
            int a = random.nextInt(letters.length() - 1);
            String rand = letters.substring(a, a + 1);
            strCode = strCode + rand;
        }
        result.put("success", strCode);
        request.getSession().setAttribute(KAPTCHA_CODE_IN_SESSION, strCode);
        return result;
    }
    
    // ------------------------------------------------------------------------------------------------------ 管理员部分
    /**
     * 管理员后台首页
     * 
     * @param model
     * @return
     * @author Henry(fba02)
     * @version [版本号, 2017年11月18日]
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/adminIndex")
    public String adminIndex(Model model) {
        standardPageUtil.init(model);
        return "management/admin_index";
    }
    
    /**
     * 管理员后台登录
     * 
     * @param model
     * @param loginName
     * @param password
     * @param kaptcha
     * @param request
     * @return
     * @author Henry(fba02)
     * @version [版本号, 2017年11月18日]
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/adminLogin")
    public String loginDemo(Model model, @RequestParam(value = "loginName") String loginName, @RequestParam(value = "password") String password, @RequestParam(value = "kaptcha") String kaptcha, HttpServletRequest request) {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^:" + loginName + "," + password + "," + kaptcha);
        MyLocale myLocale = new MyLocale();
        if (StringUtils.isBlank(loginName)) {
            model.addAttribute("error", myLocale.getText("login.name.is.empty"));
            return ADMIN_LOGIN_FORM;
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("error", myLocale.getText("pass.word.is.empty"));
            return ADMIN_LOGIN_FORM;
        }
        if (StringUtils.isBlank(kaptcha)) {
            model.addAttribute("error", myLocale.getText("kaptcha.is.empty"));
            return ADMIN_LOGIN_FORM;
        }
        String session_kaptcha = (String)request.getSession().getAttribute(KAPTCHA_CODE_IN_SESSION);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^:" + session_kaptcha);
        if (StringUtils.isNotBlank(session_kaptcha) && !session_kaptcha.toLowerCase().equals(kaptcha.toLowerCase())) {
            model.addAttribute("error", myLocale.getText("kaptcha.input.error"));
            return ADMIN_LOGIN_FORM;
        }
        // 校验用户名和密码是否正确
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setRemoteAddr(getRequestIpAddr(request));
        userSingleton.setUser(user);
        return "redirect:/adminIndex";
    }
    
    /**
     * 获取请求IP
     * 
     * @param request
     * @return
     * @author Henry(fba02)
     * @version [版本号, 2017年11月18日]
     * @see [类、类#方法、类#成员]
     */
    public static String getRequestIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}