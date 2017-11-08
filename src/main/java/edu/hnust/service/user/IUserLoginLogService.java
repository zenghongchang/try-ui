package edu.hnust.service.user;

import java.util.Map;

import edu.hnust.dto.ReturnPageData;
import edu.hnust.orm.user.UserLoginLog;

public interface IUserLoginLogService {
    /**
     * 创建登录日志
     * 
     * @param loginLog
     * @return
     */
    public Long createLog(UserLoginLog loginLog);
    
    /**
     * 分页,条件查询用户登录日志
     * 
     * @param queryMap
     * @return
     */
    public ReturnPageData<UserLoginLog> pageQueryLoginLog(Map<String, Object> queryMap);
    
    /**
     * id 查找登录日志
     * 
     * @param logId
     * @return
     */
    public UserLoginLog fetchById(Long logId);
    
    /**
     * 更新登录日志
     * 
     * @param loginLog
     * @return
     */
    public Boolean updateUserLoginLog(UserLoginLog loginLog);
    
    /**
     * name查找用户最后登录时间
     * 
     * @param loginName
     * @return
     */
    public UserLoginLog fetchUserLastLoginTimeByName(String loginName);
    
    /**
     * id查找用户最后登录时间
     * 
     * @param loginName
     * @return
     */
    public UserLoginLog fetchUserLastLoginTimeByUserId(Integer userId);
    
    /**
     * 根据sessionId获取上次记录的时间
     * 
     * @param sessionId
     * @return
     */
    public String fetchRecordTimeBySessionId(String sessionId);
    
    /**
     * 根据sessionId记录当前时间
     * 
     * @param sessionId
     * @return
     */
    public Boolean recordCurrentTimeBySessionId(String sessionId);
    
    /**
     * 根据sessionId清除记录时间
     * 
     * @param sessionId
     * @return
     */
    public Boolean cleanRecordTimeBySessionId(String sessionId);    
}
