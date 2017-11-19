package edu.hnust.application.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.hnust.application.common.page.Pager;
import edu.hnust.application.common.page.ReturnPageData;
import edu.hnust.application.core.system.StandardPageUtil;
import edu.hnust.application.orm.user.User;
import edu.hnust.application.service.user.IUserService;

@Scope("prototype")
@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    private StandardPageUtil standardPageUtil;
    
    @Autowired
    private IUserService userService;
    
    @RequestMapping(value = "userManage")
    public String userManage(Model model) {
        standardPageUtil.init(model);
        ReturnPageData<User> data = userService.pageQueryUser(new HashMap<String, Object>());
        Pager pager = new Pager(1, 20);
        if (data == null) {
            model.addAttribute("userList", new ArrayList<User>());
            model.addAttribute("count", 0L);
            pager.setTotalRecords(0L);
        } else {
            model.addAttribute("userList", data.getCollection());
            model.addAttribute("count", data.getCollectionCount());
            pager.setTotalRecords(data.getCollectionCount());
        }
        model.addAttribute("pager", pager);
        return "management/user_manage";
    }
}
