package edu.hnust.application.core;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class Script {
    @Autowired
    private HttpServletRequest request;
    
    public Script() {
    }
    
    public String runScript() {
        String type = request.getParameter("type");
        if (null == type) {
            System.out.println("type is null");
            return "success";
        }
        String args = request.getParameter("args");
        type = type.replace("/", ".");
        String className = (new StringBuilder()).append("edu.hnust.script.").append(type).toString();
        String runScriptMethod = "runScript";
        try {
            Class<?> class1 = Class.forName(className);
            Method method = class1.getMethod(runScriptMethod, new Class[] {String.class});
            method.invoke(class1.newInstance(), new Object[] {args});
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Done!");
        return "success";
    }
}