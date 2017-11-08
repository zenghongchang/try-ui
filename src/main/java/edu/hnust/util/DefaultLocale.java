package edu.hnust.util;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.hnust.core.UserSingleton;

@Component
public class DefaultLocale {
	
	@Autowired
	private UserSingleton userSingleton;
	private static DefaultLocale defaultLocale;
	
	@PostConstruct
	public void init(){
		defaultLocale = this ;
		defaultLocale.userSingleton = this.userSingleton ;

	}
	
	public UserSingleton getUserSingleton() {
		return userSingleton;
	}

	public void setUserSingleton(UserSingleton userSingleton) {
		this.userSingleton = userSingleton;
	}
	
	public static Locale getDefaultLocale() {
		String language = "cn";// 30
		try {
			UserSingleton userSingleton = defaultLocale.getUserSingleton();
			if (null != userSingleton && userSingleton.getUserInfor() != null
					&& userSingleton.getUserInfor().getUser().getLanguage() != null) {// 35
				//Dumper.dump(userSingleton.getUserInfo());
				language = userSingleton.getUserInfor().getUser().getLanguage();// 36
			}
			
		} catch (Exception arg1) {// 38
			arg1.printStackTrace();
			return Locale.getDefault();
		}

		return new Locale(language);// 41
	}
}