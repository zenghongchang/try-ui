package edu.hnust.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    
    @Override
    public ModelAndView resolveException(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, Exception ex) {
        BaseException baseException = null;
        if (ex instanceof BaseException) {
            baseException = (BaseException)ex;
        } else {
            baseException = new BaseException(getExceptionDetail(ex));
        }
        String message = baseException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.addObject("ex", ex);
        modelAndView.setViewName("page/error");
        return modelAndView;
    }
    
    private String getExceptionDetail(Exception e) {
        StringBuffer stringBuffer = new StringBuffer(e.toString() + "\n");
        StackTraceElement[] messages = e.getStackTrace();
        int length = messages.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append("\t" + messages[i].toString() + "\n");
        }
        return stringBuffer.toString();
    }
}