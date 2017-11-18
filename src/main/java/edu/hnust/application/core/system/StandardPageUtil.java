package edu.hnust.application.core.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import edu.hnust.application.core.UserSingleton;

@Component
public class StandardPageUtil {
    @Autowired
    private UserSingleton userSingleton;    
    @Autowired
    private HttpServletRequest request;
    
    public void init(Model model) {
        if (null != userSingleton) {
            model.addAttribute("currentUser", userSingleton.getUser());
            if (null != request) {
                // 当前请求URL
                String str = request.getRequestURI().substring(request.getContextPath().length());
                model.addAttribute("currentUrl", str);                
            }
        }
    }
    
    public String ajaxSuccess(Model paramModel) {
        return "page/ajax/success";
    }
    
    public String ajaxFailure(Model paramModel, BindingResult paramBindingResult) {
        List<String> localArrayList = new ArrayList<>();
        if (null != paramBindingResult) {
            for (ObjectError localObjectError : paramBindingResult.getAllErrors()) {
                localArrayList.add(localObjectError.getDefaultMessage());
            }
        }
        paramModel.addAttribute("errors", localArrayList);
        return "page/ajax/failure";
    }
}