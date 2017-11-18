package edu.hnust.application.service.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import edu.hnust.application.common.rest.CustomBasicService;

public class BaseService extends CustomBasicService {
    private final static String TRY_UI_SERVICE_ADDRESS = "TRY_UI_SERVER_ADDRESS";    
    private final static String TRY_UI_SERVICE_TOKEN = "TRY_UI_TOKEN_CODE";
    
    private static String address;    
    private static String token;
    
    public static final Logger logger = Logger.getLogger(BaseService.class);// 日志文件
    
    public BaseService() {
        if (StringUtils.isEmpty(address)) {
            address = System.getenv(TRY_UI_SERVICE_ADDRESS);
        }
        if (StringUtils.isEmpty(token)) {
            token = System.getenv(TRY_UI_SERVICE_TOKEN);
        }
        if (StringUtils.isBlank(token)) {
            token = "demo";
        }
        if (StringUtils.isBlank(address)) {
            address = "http://192.168.1.102:38366";
        }
        logger.info("address:" + address);
        this.setServiceAddress(address);
        logger.info("token:" + token);
        this.setServiceToken(token);
    }
}