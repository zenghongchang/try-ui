package edu.hnust.application.core;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.hnust.application.core.map.SessionMap;
import edu.hnust.application.orm.user.User;

@Component("userSingleton")
public class UserSingleton {
    private final static String USERSESSION = "user_session_map";
    
    @Autowired
    private SessionMap sessionMap;
    
    private UserSingleton() {
    }
    
    public User getUser() {
        Object u = sessionMap.get(USERSESSION);
        return null == u ? null : (User)u;
    }
    
    public void setUser(User user) {
        sessionMap.put(USERSESSION, user);
    }
    
    public void unsetUserInfor() {
        sessionMap.destoryAll();
    }
    
    public static UserSingleton getInstance() {
        return UserSingleton.UserSingletonHolder.INSTANCE;
    }
    
    public boolean isSuperUser() {
        return this.isSuperUser(this.getUser().getLoginName()).booleanValue();
    }
    
    public Boolean isSuperUser(String loginName) {
        HashSet<String> superUsers = new HashSet<String>();
        superUsers.add("101");
        superUsers.add("107");
        Boolean isSuperUser = Boolean.valueOf(superUsers.contains(this.getUser().getLoginName())) || this.getUser().getIsSuperUser() == 1;
        return isSuperUser;
    }
    
    private static class UserSingletonHolder {
        private static final UserSingleton INSTANCE = new UserSingleton();
    }
}