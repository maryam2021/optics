package optics.com.handler.customerhandler;

import optics.com.domain.customer.Customer;
import optics.com.model.customermodel.CustomerModel;
import optics.com.service.customerservice.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerHandler {
    @Autowired
    private CustomerServiceImpl customerService;

    public void save(CustomerModel customerModel) {
       Customer customer = customerModel.toCustomer(customerModel);
       customerService.save(customer);

    }
}