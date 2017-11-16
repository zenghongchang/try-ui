package edu.hnust.application.service.user;

import edu.hnust.application.orm.user.Customer;

public interface ICustomerService {
    public Customer fetchCustomrtById(Integer id);
}
