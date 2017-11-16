package edu.hnust.application.common.util;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.hnust.application.core.UserSingleton;

@Component
public class DefaultLocale {
    
    @Autowired
    private UserSingleton userSingleton;    
    private static DefaultLocale defaultLocale;
    
    @PostConstruct
    public void init() {
        defaultLocale = this;
        defaultLocale.userSingleton = this.userSingleton;        
    }
    
    public UserSingleton getUserSingleton() {
        return userSingleton;
    }
    
    public void setUserSingleton(UserSingleton userSingleton) {
        this.userSingleton = userSingleton;
    }
    
    public static Locale getDefaultLocale() {
        String language = "cn";
        try {
            UserSingleton userSingleton = defaultLocale.getUserSingleton();
            if (null != userSingleton && userSingleton.getUser() != null && userSingleton.getUser().getLanguage() != null) {
                language = userSingleton.getUser().getLanguage();
            }            
        } catch (Exception arg1) {
            arg1.printStackTrace();
            return Locale.getDefault();
        }
        
        return new Locale(language);
    }
}