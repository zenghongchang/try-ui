package edu.hnust.service.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import edu.hnust.common.rest.CustomBasicService;

public class BaseService extends CustomBasicService {
    private final static String TPMC_SERVICE_ADDRESS = "TOMTOP_TPMC_SERVER_ADDRESS";    
    private final static String TPMC_SERVICE_TOKEN = "TOMTOP_TPMC_TOKEN_CODE";
    
    private static String address;    
    private static String token;
    
    public static final Logger logger = Logger.getLogger(BaseService.class);// 日志文件
    
    public BaseService() {
        if (StringUtils.isEmpty(address)) {
            address = System.getenv(TPMC_SERVICE_ADDRESS);
        }
        if (StringUtils.isEmpty(token)) {
            token = System.getenv(TPMC_SERVICE_TOKEN);
        }
        if (StringUtils.isBlank(token)) {
            token = "demo";
        }
        if (StringUtils.isBlank(address)) {
            address = "http://192.168.180.182:24614";
        }
        logger.info("address:" + address);
        this.setServiceAddress(address);
        logger.info("token:" + token);
        this.setServiceToken(token);
    }
}