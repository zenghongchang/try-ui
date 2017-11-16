package edu.hnust.application.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryUtil implements ApplicationContextAware{
	
	private static ApplicationContext ac;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ac=applicationContext;
	}
	
	public static ApplicationContext getApplicationContext(){
		return ac; 
	}

    public static Object getBean(String name){
    	 return getApplicationContext().getBean(name);
    }
    
    public static <T> T getBean(String name,Class<T> clz){
    	return getApplicationContext().getBean(name,clz);
    }

}
