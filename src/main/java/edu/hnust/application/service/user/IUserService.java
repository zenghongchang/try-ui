package edu.hnust.application.service.user;

import java.util.List;
import java.util.Map;

import edu.hnust.application.common.page.ReturnPageData;
import edu.hnust.application.orm.user.User;

public interface IUserService {
    
    /**
     * 用户登陆校验
     * @param loginName
     * @param password
     * @return
     */
    public User validateUser(String loginName, String password);
    /**
     * @param map
     * @return
     */
    public List<User> queryUserByKey(Map<String, Object> map);
    
    /**
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map);
    
    /**
     * @param user
     * @return
     */
    public Boolean updateUser(User user);
    
    /**
     * @param user
     * @return
     */
    public Boolean addUser(User user);
    
    /**
     * @param id
     * @return
     */
    public Boolean deleteUserById(Integer id);
    
    /**
     * @param id
     * @return
     */
    public User queryUserById(Integer id);
    
    /**
     * 分页查询
     * @param requst
     * @return
     */
    public ReturnPageData<User> pageQueryUser(Map<String, Object> requst);
}