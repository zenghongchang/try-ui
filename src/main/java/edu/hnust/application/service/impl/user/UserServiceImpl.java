package edu.hnust.application.service.impl.user;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import edu.hnust.application.common.util.JsonConverter;
import edu.hnust.application.orm.user.User;
import edu.hnust.application.service.base.BaseService;
import edu.hnust.application.service.user.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseService implements IUserService {    
    private final String LOGIN = "/user/login";    
    private final String QUERY_USER = "/user/queryUser";    
    private final String DELETE_USER = "/user/deleteUser";    
    private final String UPDATE_USER = "/user/updateUser";    
    private final String TOTAL_USER = "/user/getTotalUser";    
    private final String ADD_USER = "/user/addUser";    
    private final String FIND_USER_BY_ID = "/user/findUserById";    
    private final String FIND_USER_SUB = "/user/findUserSubOrSup";    
    private final String FIND_USERS_BY_GROUPID = "/user/findUsersByGroupId";    
    private final String FIND_USERS_BY_GROUPID_EXCEPT = "/user/findUsersByGroupIdExcept";    
    private final String FIND_USERS_BY_FACTORYID = "/user/findUsersByFactoryId";    
    private final String FIND_USERS_BY_PROVIDERID = "/user/findUsersByProviderId";
    
    @Override
    public User login(User user) {
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("loginName", user.getLoginName());
        headers.add("password", user.getPassword());
        return returnBack(new TypeReference<User>() {}, LOGIN, headers);
    }
    
    @Override
    public List<User> findUser(Map<String, Object> map) {
        setServiceEntry(QUERY_USER);
        setServiceRequest(JsonConverter.format(map));        
        return returnBack(new TypeReference<List<User>>() {}, QUERY_USER);
    }
    
    @Override
    public Boolean updateUser(User user) {
        setServiceEntry(UPDATE_USER);
        setServiceRequest(JsonConverter.format(user));        
        return returnBack(new TypeReference<Boolean>() {}, UPDATE_USER);
    }
    
    @Override
    public Long getTotalUser(Map<String, Object> map) {
        setServiceEntry(TOTAL_USER);
        setServiceRequest(JsonConverter.format(map));        
        return returnBack(new TypeReference<Long>() {}, TOTAL_USER);
    }
    
    @Override
    public Boolean addUser(User user) {
        setServiceEntry(ADD_USER);
        setServiceRequest(JsonConverter.format(user));        
        return returnBack(new TypeReference<Boolean>() {}, ADD_USER);
    }
    
    @Override
    public int deleteUser(Integer id) {
        setServiceEntry(DELETE_USER);
        setServiceRequestId(id);        
        return returnBack(new TypeReference<Integer>() {}, DELETE_USER);
    }
    
    @Override
    public User findById(Integer id) {
        setServiceEntry(FIND_USER_BY_ID);
        setServiceRequestId(id);
        return returnBack(new TypeReference<User>() {}, FIND_USER_BY_ID);
    }
    
    public List<User> findUserSubOrSup(Map<String, Object> map) {
        setServiceEntry(FIND_USER_SUB);
        setServiceRequest(JsonConverter.format(map));
        return returnBack(new TypeReference<List<User>>() {}, FIND_USER_SUB);
    }
    
    @Override
    public List<User> findUsersByGroupId(Integer groupId) {
        setServiceEntry(FIND_USERS_BY_GROUPID);
        setServiceRequest(JsonConverter.format(groupId));
        return returnBack(new TypeReference<List<User>>() {}, FIND_USERS_BY_GROUPID);
    }
    
    @Override
    public List<User> findUsersByGroupIdExcept(Integer groupId) {
        setServiceEntry(FIND_USERS_BY_GROUPID_EXCEPT);
        setServiceRequest(JsonConverter.format(groupId));
        return returnBack(new TypeReference<List<User>>() {}, FIND_USERS_BY_GROUPID_EXCEPT);
    }
    
    @Override
    public List<User> findUsersByFactoryId(Integer factoryId) {
        setServiceEntry(FIND_USERS_BY_FACTORYID);
        setServiceRequest(JsonConverter.format(factoryId));
        return returnBack(new TypeReference<List<User>>() {
        }, FIND_USERS_BY_FACTORYID);
    }
    
    @Override
    public List<User> findUsersByProviderId(Integer providerId) {
        setServiceEntry(FIND_USERS_BY_PROVIDERID);
        setServiceRequest(JsonConverter.format(providerId));
        return returnBack(new TypeReference<List<User>>() {}, FIND_USERS_BY_PROVIDERID);
    }
}