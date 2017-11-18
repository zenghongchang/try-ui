package edu.hnust.application.service.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import edu.hnust.application.common.page.ReturnPageData;
import edu.hnust.application.common.util.JsonConverter;
import edu.hnust.application.orm.user.User;
import edu.hnust.application.service.base.BaseService;
import edu.hnust.application.service.user.IUserService;

/**
 * 用户操作接口
 * 
 * @author Henry(fba02)
 * @version [版本号, 2017年11月18日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements IUserService {
    
    private final String VALIDATE_USER = "/user/validateUser";    
    private final String QUERY_USER_BY_KEY = "/user/queryUserByKey";    
    private final String GET_TOTAL_USER = "/user/getTotalUser";    
    private final String UPDATE_USER = "/user/updateUser";
    private final String ADD_USER = "/user/addUser";
    private final String DELETE_USER_BY_ID = "/user/deleteUserById";    
    private final String QUERY_USER_BY_ID = "/user/queryUserById";    
    private final String PAGE_QUERY_USER = "/user/pageQueryUser"; 

    @Override
    public User validateUser(String loginName, String password) {
        Map<String, String> requestArgs = new HashMap<String, String>();
        requestArgs.put("loginName", loginName);
        requestArgs.put("password", password);
        setServiceEntry(VALIDATE_USER);
        setServiceRequest(JsonConverter.format(requestArgs));
        return returnBack(new TypeReference<User>() {}, VALIDATE_USER);
    }
    
    @Override
    public List<User> queryUserByKey(Map<String, Object> map) {
        setServiceEntry(QUERY_USER_BY_KEY);
        setServiceRequest(JsonConverter.format(map));
        return returnBack(new TypeReference<List<User>>() {}, QUERY_USER_BY_KEY);
    }
    
    @Override
    public Long getTotalUser(Map<String, Object> map) {
        setServiceEntry(GET_TOTAL_USER);
        setServiceRequest(JsonConverter.format(map));
        return returnBack(new TypeReference<Long>() {}, GET_TOTAL_USER);
    }
    
    @Override
    public Boolean updateUser(User user) {
        setServiceEntry(UPDATE_USER);
        setServiceRequest(JsonConverter.format(user));
        return returnBack(new TypeReference<Boolean>() {}, UPDATE_USER);
    }
    
    @Override
    public Boolean addUser(User user) {
        setServiceEntry(ADD_USER);
        setServiceRequest(JsonConverter.format(user));
        return returnBack(new TypeReference<Boolean>() {}, ADD_USER);
    }
    
    @Override
    public Boolean deleteUserById(Integer id) {
        setServiceEntry(DELETE_USER_BY_ID);
        setServiceRequestId(id.toString());
        return returnBack(new TypeReference<Boolean>() {}, DELETE_USER_BY_ID);
    }
    
    @Override
    public User queryUserById(Integer id) {
        setServiceEntry(QUERY_USER_BY_ID);
        setServiceRequestId(id.toString());
        return returnBack(new TypeReference<User>() {}, QUERY_USER_BY_ID);
    }
    
    @Override
    public ReturnPageData<User> pageQueryUser(Map<String, Object> requst) {
        setServiceEntry(PAGE_QUERY_USER);
        setServiceRequest(JsonConverter.format(requst));
        return returnBack(new TypeReference<ReturnPageData<User>>() {}, PAGE_QUERY_USER);
    }
}