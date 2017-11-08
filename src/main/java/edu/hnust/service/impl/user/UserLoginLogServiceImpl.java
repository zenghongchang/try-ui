package edu.hnust.service.impl.user;

import java.util.Map;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.hnust.dto.ReturnPageData;
import edu.hnust.orm.user.UserLoginLog;
import edu.hnust.service.base.BaseService;
import edu.hnust.service.user.IUserLoginLogService;
import edu.hnust.util.JsonConverter;
@Scope("prototype")
@Service("userLoginLogService")
public class UserLoginLogServiceImpl extends BaseService implements IUserLoginLogService{ 
	
	private  final String FETCH_BY_ID="/user/fetchUserLoginLogById";
	private  final String SAVE_USER_LOGIN_LOG="/user/saveUserLoginLog";
	private  final String UPDATE_USER_LOGIN_LOG="/user/updateUserLoginLog";
	private  final String PAGE_QUERY_LOGIN_LOG="/user/pageQueryLoginLog";
	private  final String FETCH_LAST_LOGIN_TIME_BY_LOGIN_NAME="/user/fetchLastLoginTimeByLoginName";
	private  final String FETCH_LAST_LOGIN_TIME_BY_USERID="/user/fetchLastLoginTimeByUserId";
	private  final String FETCH_RECORD_TIME_BY_SESSIONID="/user/fetchRecordTimeBySessionId";
	private  final String RECORD_CURRENT_TIME_BY_SESSIONID="/user/recordCurrentTimeBySessionId";
	private  final String CLEAN_RECORD_TIME_BY_SESSIONID="/user/cleanRecordTimeBySessionId";
	
	@Override
	public Long createLog(UserLoginLog loginLog) {
		setServiceEntry(SAVE_USER_LOGIN_LOG);
		setServiceRequest(JsonConverter.format(loginLog));
		return returnBack(new TypeReference<Long>() {}, SAVE_USER_LOGIN_LOG);
	}
	
	@Override
	public ReturnPageData<UserLoginLog> pageQueryLoginLog(Map<String, Object> queryMap) {
		setServiceEntry(PAGE_QUERY_LOGIN_LOG);
		setServiceRequest(JsonConverter.format(queryMap));
		return returnBack(new TypeReference<ReturnPageData<UserLoginLog>>() {}, PAGE_QUERY_LOGIN_LOG);
	}
	
	@Override
	public UserLoginLog fetchById(Long logId) {
		setServiceEntry(FETCH_BY_ID);
		setServiceRequestId(logId);
		return returnBack(new TypeReference<UserLoginLog>() {}, FETCH_BY_ID);
	}
	
	@Override
	public Boolean updateUserLoginLog(UserLoginLog loginLog) {
		setServiceEntry(UPDATE_USER_LOGIN_LOG);
		setServiceRequest(JsonConverter.format(loginLog));
		return returnBack(new TypeReference<Boolean>() {}, UPDATE_USER_LOGIN_LOG);
	}
	
	
	@Override
	public UserLoginLog fetchUserLastLoginTimeByName(String loginName) {
		setServiceEntry(FETCH_LAST_LOGIN_TIME_BY_LOGIN_NAME);
		setServiceRequest(loginName);
		return returnBack(new TypeReference<UserLoginLog>() {}, FETCH_LAST_LOGIN_TIME_BY_LOGIN_NAME);
	}

	@Override
	public UserLoginLog fetchUserLastLoginTimeByUserId(Integer userId) {
		setServiceEntry(FETCH_LAST_LOGIN_TIME_BY_USERID);
		setServiceRequestId(userId);
		return returnBack(new TypeReference<UserLoginLog>() {}, FETCH_LAST_LOGIN_TIME_BY_USERID);
	}

	@Override
	public String fetchRecordTimeBySessionId(String sessionId) {
		setServiceEntry(FETCH_RECORD_TIME_BY_SESSIONID);
		setServiceRequest(sessionId);
		return returnBack(new TypeReference<String>() {}, FETCH_RECORD_TIME_BY_SESSIONID);
	}

	@Override
	public Boolean recordCurrentTimeBySessionId(String sessionId) {
		setServiceEntry(RECORD_CURRENT_TIME_BY_SESSIONID);
		setServiceRequest(sessionId);
		return returnBack(new TypeReference<Boolean>() {}, RECORD_CURRENT_TIME_BY_SESSIONID);
	}

	@Override
	public Boolean cleanRecordTimeBySessionId(String sessionId) {
		setServiceEntry(CLEAN_RECORD_TIME_BY_SESSIONID);
		setServiceRequest(sessionId);
		return returnBack(new TypeReference<Boolean>() {}, CLEAN_RECORD_TIME_BY_SESSIONID);
	}
}