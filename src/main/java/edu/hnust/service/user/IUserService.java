package edu.hnust.service.user;

import java.util.List;
import java.util.Map;

import edu.hnust.orm.user.User;

public interface IUserService {
    /**
     * @param user
     * @return
     */
    public User login(User user);
    
    /**
     * @param map
     * @return
     */
    public List<User> findUser(Map<String, Object> map);
    
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
    public int deleteUser(Integer id);
    
    /**
     * @param id
     * @return
     */
    public User findById(Integer id);
    
    /**
     * 查询用户对应上下级
     * 
     * @param map
     * @return
     */
    public List<User> findUserSubOrSup(Map<String, Object> map);
    
    /**
     * 查询组包含的用户
     * 
     * @param groupId
     * @return
     */
    public List<User> findUsersByGroupId(Integer groupId);
    
    /**
     * 查询组不包含的用户
     * 
     * @param groupId
     * @return
     */
    public List<User> findUsersByGroupIdExcept(Integer groupId);
    
    /**
     * 查询工厂权限的用户
     * 
     * @param factoryId
     * @return
     */
    public List<User> findUsersByFactoryId(Integer factoryId);
    
    /**
     * 查询供应商权限
     * 
     * @param id
     * @return
     */
    public List<User> findUsersByProviderId(Integer id);
}