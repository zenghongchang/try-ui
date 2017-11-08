package edu.hnust.common.rest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import edu.hnust.dto.ServiceResponse;
import edu.hnust.util.JsonConverter;

public class CustomBasicService extends RestBasicService {
    public static final Logger logger = Logger.getLogger(CustomBasicService.class);// 日志文件
    
    public String returnBack(String url, MultiValueMap<String, Object> headers) {
        RestTemplate rest = new RestTemplate();
        try {
            String requestUrl = StringUtils.stripEnd(getServiceAddress(), "/") + StringUtils.stripEnd(url, "/") + "?token=" + getServiceToken();
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + requestUrl);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + headers.toString());
            logger.info("requestUrl：" + requestUrl);
            logger.info("headers：" + headers.toString());
            headers.add("Accept", "application/json;charset=utf-8");
            headers.add("Content-Type", "application/json;charset=utf-8");            
            String string = rest.postForObject(requestUrl, headers, String.class);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T returnBack(TypeReference<T> tr, String url, MultiValueMap<String, Object> headers) {
        RestTemplate rest = new RestTemplate();
        try {
            String requestUrl = StringUtils.stripEnd(getServiceAddress(), "/") + StringUtils.stripEnd(url, "/") + "?token=" + getServiceToken();
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + requestUrl);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + headers.toString());
            logger.info("requestUrl：" + requestUrl);
            logger.info("headers：" + headers.toString());
            headers.add("Accept", "application/json;charset=utf-8");
            headers.add("Content-Type", "application/json;charset=utf-8");
            String string = rest.postForObject(requestUrl, headers, String.class);            
            ServiceResponse<T> serviceResponse = JsonConverter.parse(string, ServiceResponse.class);            
            if (200 == serviceResponse.getCode()) {
                JsonNode jsonNode = JsonConverter.getNode(string, "result");
                if (null != jsonNode) {
                    return JsonConverter.jsonNode2GenericObject(jsonNode, tr);
                }
            } else {
                System.out.println(serviceResponse.getDescription());
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> T returnBack(TypeReference<T> tr, String url) {
        RestTemplate rest = new RestTemplate();
        try {
            String requestUrl = StringUtils.stripEnd(getServiceAddress(), "/") + StringUtils.stripEnd(url, "/") + "?token=" + getServiceToken();
            if (null == getServiceRequest()) {
                setServiceRequest("{}");
            }
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + requestUrl);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + getServiceRequest());
            logger.info("requestUrl：" + requestUrl);
            logger.info("headers：" + getServiceRequest());
            MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
            headers.add("Accept", "application/json;charset=utf-8");
            headers.add("Content-Type", "application/json;charset=utf-8");
            String requestBody = getServiceRequest();
            HttpEntity httpEntity = new HttpEntity(requestBody, headers);            
            String s = rest.postForObject(requestUrl, httpEntity, String.class);            
            ServiceResponse<T> serviceResponse = JsonConverter.parse(s, ServiceResponse.class);            
            if (200 == serviceResponse.getCode()) {
                JsonNode jsonNode = JsonConverter.getNode(s, "result");
                if (null != jsonNode) {
                    return JsonConverter.jsonNode2GenericObject(jsonNode, tr);
                }
            } else {
                System.out.println(serviceResponse.getDescription());
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public String returnBack(String url) {
        RestTemplate rest = new RestTemplate();
        try {
            String requestUrl = StringUtils.stripEnd(getServiceAddress(), "/") + StringUtils.stripEnd(url, "/") + "?token=" + getServiceToken();
            if (null == getServiceRequest()) {
                setServiceRequest("{}");
            }
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + requestUrl);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + getServiceRequest());
            logger.info("requestUrl：" + requestUrl);
            logger.info("headers：" + getServiceRequest());
            MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
            headers.add("Accept", "application/json;charset=utf-8");
            headers.add("Content-Type", "application/json;charset=utf-8");
            String requestBody = getServiceRequest();
            HttpEntity httpEntity = new HttpEntity(requestBody, headers);            
            String s = rest.postForObject(requestUrl, httpEntity, String.class);            
            return s;            
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return null;
    }
}