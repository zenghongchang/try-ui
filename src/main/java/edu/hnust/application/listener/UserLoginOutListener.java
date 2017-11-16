package edu.hnust.application.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import edu.hnust.application.common.util.BeanFactoryUtil;
import edu.hnust.application.common.util.DateUtil;
import edu.hnust.application.orm.user.User;
import edu.hnust.application.orm.user.UserLoginLog;
import edu.hnust.application.service.user.IUserLoginLogService;

@Component("userLoginOutListener")
public class UserLoginOutListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        String sessionId = session.getId();
        try {
            Long id = (Long)session.getAttribute("login-log-id");
            User user = (User)session.getAttribute("user_session_map");
            if (null != user) {
                IUserLoginLogService userLoginLogService = (IUserLoginLogService)BeanFactoryUtil.getBean("userLoginLogService");
                UserLoginLog ull = userLoginLogService.fetchById(id);
                if (null != ull) {
                    String loginTime = ull.getLoginTime();
                    String logoutTime = userLoginLogService.fetchRecordTimeBySessionId(sessionId);
                    if (StringUtils.isEmpty(logoutTime)) {
                        logoutTime = DateUtil.getCurrentDateTimeAsString();
                    }
                    Long duration = DateUtil.calIntervalTime(logoutTime, loginTime);
                    ull.setLogoutTime(logoutTime);
                    ull.setDuration(duration);
                    userLoginLogService.updateUserLoginLog(ull);
                }
                userLoginLogService.cleanRecordTimeBySessionId(sessionId);
                session.removeAttribute("login-log-id");
                session.removeAttribute("recordTime");
                session.removeAttribute("userSession");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}