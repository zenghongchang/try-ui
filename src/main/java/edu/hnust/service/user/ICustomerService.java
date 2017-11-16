package edu.hnust.service.user;

import edu.hnust.orm.user.Customer;

public interface ICustomerService {
    public Customer fetchCustomrtById(Integer id);
}
