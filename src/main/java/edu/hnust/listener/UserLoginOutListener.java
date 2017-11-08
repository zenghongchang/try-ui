package edu.hnust.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import edu.hnust.dto.user.UserInfor;
import edu.hnust.orm.user.UserLoginLog;
import edu.hnust.service.user.IUserLoginLogService;
import edu.hnust.util.BeanFactoryUtil;
import edu.hnust.util.DateUtil;

@Component("userLoginOutListener")
public class UserLoginOutListener implements HttpSessionListener {    
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // TODO
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        String sessionId = session.getId();
        try {
            Long id = (Long)session.getAttribute("login-log-id");
            UserInfor user = (UserInfor)session.getAttribute("userSession");
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