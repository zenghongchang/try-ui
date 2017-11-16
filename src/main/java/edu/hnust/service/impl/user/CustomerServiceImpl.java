package edu.hnust.service.impl.user;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import edu.hnust.orm.user.Customer;
import edu.hnust.service.base.BaseService;
import edu.hnust.service.user.ICustomerService;

@Service("customerService")
public class CustomerServiceImpl extends BaseService implements ICustomerService {
    private final String FETCH_CUSTOMRT_BY_ID = "/customer/queryCustomerById";
    
    @Override
    public Customer fetchCustomrtById(Integer id) {
        setServiceEntry(FETCH_CUSTOMRT_BY_ID);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("id", id.toString());
        return returnBack(new TypeReference<Customer>() {
        }, FETCH_CUSTOMRT_BY_ID, headers);
    }
}
