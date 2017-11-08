package edu.hnust.core;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.hnust.core.map.SessionMap;
import edu.hnust.dto.user.UserInfor;

@Component("userSingleton")
public class UserSingleton {
    private final static String USERSESSION = "userSession";    
    @Autowired
    private SessionMap sessionMap;
    
    private UserSingleton() {
    }
    
    public UserInfor getUserInfor() {
        Object u = sessionMap.get(USERSESSION);
        return null == u ? null : (UserInfor)u;
    }
    
    public void setUser(UserInfor user) {
        sessionMap.put(USERSESSION, user);
    }
    
    public void unsetUserInfor() {
        sessionMap.destoryAll();
    }
    
    public static UserSingleton getInstance() {
        return UserSingleton.UserSingletonHolder.INSTANCE;
    }
    
    public boolean isSuperUser() {
        return this.isSuperUser(this.getUserInfor().getUser().getLoginName()).booleanValue();
    }
    
    public Boolean isSuperUser(String loginName) {
        HashSet<String> superUsers = new HashSet<String>();
        superUsers.add("101");
        superUsers.add("107");
        Boolean isSuperUser = Boolean.valueOf(superUsers.contains(this.getUserInfor().getUser().getLoginName()));
        return isSuperUser;
    }
    
    private static class UserSingletonHolder {
        private static final UserSingleton INSTANCE = new UserSingleton();
    }
}