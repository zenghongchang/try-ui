package edu.hnust.controller.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hnust.service.user.ICustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    
    @RequestMapping(value = "/queryCustomerById")
    @ResponseBody
    public Map<String, Object> queryCustomerById(String id) {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^:" + id);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", customerService.fetchCustomrtById(Integer.valueOf(id)));
        return result;
    }
}