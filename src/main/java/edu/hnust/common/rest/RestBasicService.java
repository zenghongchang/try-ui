package edu.hnust.common.rest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import edu.hnust.dto.ServiceResponseCode;
import edu.hnust.util.Json;
import edu.hnust.util.JsonConverter;

public abstract class RestBasicService {
    private RestTemplate restTemplate;    
    private static Map<String, Map<String, String>> serviceConfigs = new HashMap<String, Map<String, String>>();
    
    private String serviceAddress;    
    private String serviceEntry;    
    private String serviceRequest;    
    private Map<String, Object> serviceResult = new HashMap<String, Object>();    
    private String serviceToken;
    
    public RestBasicService() {
        restTemplate = new RestTemplate();
    }
    
    public String getServiceAddress() {
        return this.serviceAddress; 
    }
    
    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress; 
    } 
    
    public String getServiceEntry() {
        return this.serviceEntry; 
    }
    
    public void setServiceEntry(String serviceEntry) {
        this.serviceEntry = serviceEntry; 
    } 
    
    public String getServiceRequest() {
        return this.serviceRequest; 
    }
    
    public void setServiceRequest(HashMap<String, Object> request) {
        this.setServiceRequest(JsonConverter.format(request)); 
    } 
    
    public void setServiceRequest(String serviceRequest) {
        this.serviceRequest = serviceRequest; 
    } 
    
    public Map<String, Object> getServiceResult() {
        return this.serviceResult; 
    }
    
    public void setServiceResult(Map<String, Object> serviceResult) {
        this.serviceResult = serviceResult; 
    } 
    
    public String getServiceToken() {
        return this.serviceToken; 
    }
    
    public void setServiceToken(String serviceToken) {
        this.serviceToken = serviceToken; 
    } 
    
    protected void init(String code) {
        Map<String, String> serviceConfig = (Map<String, String>)serviceConfigs.get(code);
        if (null == serviceConfig) {
            String serviceAddressKey = "JTOMTOPERP_" + code + "_SERVICE_ADDRESS";
            String serviceTokenKey = "JTOMTOPERP_" + code + "_SERVICE_TOKEN";
            this.serviceAddress = System.getenv(serviceAddressKey);
            if (null == this.serviceAddress) {
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^error: no server config!"); 
            } else {
                this.serviceToken = System.getenv(serviceTokenKey);
            }
        } else {
            this.serviceAddress = (String)serviceConfig.get("ADDRESS");
            this.serviceToken = (String)serviceConfig.get("TOKEN");
        }
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<Map<String, Object>> requestList() {
        Object result = this._request();
        return null != result ? (List)result : null;
    }
    
    public Object request() {
        return this._request();
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    private Object _request() {
        try {
            String e = StringUtils.stripEnd(this.getServiceAddress(), "/") + StringUtils.stripEnd(this.getServiceEntry(), "/") + "?token=" + this.getServiceToken(); 
            if (null == this.getServiceRequest()) { 
                this.setServiceRequest("{}"); 
            }
            
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + StringUtils.stripEnd(this.getServiceAddress(), "/") + StringUtils.stripEnd(this.getServiceEntry(), "/")); 
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + this.getServiceRequest()); 
            LinkedMultiValueMap headers = new LinkedMultiValueMap(); 
            headers.add("Accept", "application/json;charset=utf-8"); 
            headers.add("Content-Type", "application/json;charset=utf-8"); 
            String requestBody = this.getServiceRequest(); 
            HttpEntity httpEntity = new HttpEntity(requestBody, headers); 
            this.serviceResult = (Map)this.restTemplate.postForObject(e, httpEntity, LinkedHashMap.class, new Object[0]); 
            if (!this.serviceResult.containsKey("code")) { 
                this.serviceResult.put("code", ServiceResponseCode.SERVER_ERROR); 
                return null; 
            }            
            if (null != this.serviceResult.get("result")) { 
                return this.serviceResult.get("result"); 
            }
        } catch (Exception arg) { 
            arg.printStackTrace(); 
        }        
        return null; 
    }
    
    public void setServiceRequestId(Object id) {
        Map<String, Object> hashmap = new HashMap<String, Object>();
        hashmap.put("id", id);
        this.setServiceRequest(Json.toJson(hashmap));
    }
    
    public void setServiceRequestQuery(Object query, Object sort, Object pagination) {
        this.setServiceRequestQuery(query, sort, pagination, Boolean.valueOf(true)); 
    } 
    
    public void setServiceRequestQuery(Object query, Object sort, Object pagination, Boolean excludeCount) {
        HashMap<String, Object> request = new HashMap<String, Object>(); 
        if (null != query) { 
            request.put("query", query); 
        }        
        if (null != sort) { 
            request.put("sort", sort); 
        }        
        if (null != pagination) { 
            request.put("pagination", pagination); 
        }        
        if (excludeCount.booleanValue()) { 
            request.put("excludeCount", ""); 
        }
        
        this.setServiceRequest(JsonConverter.format(request)); 
    } 
    
    public void setServiceRequestQueryGroup(Object query, Object group) {
        HashMap<String, Object> request = new HashMap<String, Object>(); 
        if (null != query) { 
            request.put("query", query); 
        }        
        request.put("group", group); 
        this.setServiceRequest(JsonConverter.format(request)); 
    } 
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public String setServiceRequestBatchUpdate(Object object) {
        if (object instanceof String) { 
            this.setServiceRequest((String)object); 
        } else {
            HashMap request;
            if (object instanceof List) { 
                request = new HashMap(); 
                request.put("updates", object); 
                this.setServiceRequest(JsonConverter.format(request)); 
            } else {
                request = new HashMap(); 
                new HashMap();
                Map updates;
                if (object instanceof Map) { 
                    updates = (Map)object; 
                } else {
                    updates = (Map)(new BeanMap(object)).getBean(); 
                }                
                request.put("ids", updates.get("ids")); 
                request.put("updates", updates); 
                this.setServiceRequest(JsonConverter.format(request)); 
            }
        }        
        return this.getServiceRequest(); 
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public String setServiceRequestUpdate(Object object) {
        if (object instanceof String) { 
            this.setServiceRequest((String)object); 
        } else {
            HashMap request = new HashMap(); 
            Map updates;
            if (object instanceof Map) {
                updates = (Map)object;
            } else {
                updates = (Map)(new BeanMap(object)).getBean();
            }            
            request.put("id", updates.get("id"));
            request.put("updates", updates); 
            this.setServiceRequest(JsonConverter.format(request)); 
        }
        
        return this.getServiceRequest(); 
    }
    
    public String setServiceRequestCreateBatch(Object object) {
        if (object instanceof String) { 
            this.setServiceRequest((String)object); 
        } else {
            this.setServiceRequest(JsonConverter.format(object)); 
        }
        
        return this.getServiceRequest(); 
    }
    
    public String setServiceRequestCreate(Object object) {
        this.setServiceRequest(JsonConverter.format(object)); 
        return this.getServiceRequest(); 
    }
    
    public Boolean checkSuccess() {
        return null != this.serviceResult && null != this.serviceResult.get("code") && ServiceResponseCode.SUCCESS.equals(this.serviceResult.get("code")) ? Boolean.valueOf(true) : Boolean.valueOf(false);                                                                                                                                                                                                  
    }
}