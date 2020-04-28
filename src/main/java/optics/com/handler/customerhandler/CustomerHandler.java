package optics.com.handler.customerhandler;

import optics.com.domain.customer.Customer;
import optics.com.model.ChangePasswordResponseModel;
import optics.com.model.changepasswordmodel.ChangePasswordModel;
import optics.com.model.customermodel.CustomerModel;
import optics.com.service.changepassword.ChangePasswordServiceImpl;
import optics.com.service.customerservice.CustomerService;
import optics.com.service.customerservice.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerHandler {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    CustomerServiceImpl customerServiceImpl;

    public void save(CustomerModel customerModel) {
        Customer customer = customerModel.toCustomer(customerModel);
        customerService.save(customer);

    }

    public List<CustomerModel> getCustomers(String userName) {
        return customerService.getCustomer(userName).stream().map(CustomerModel::new).collect(Collectors.toList());
    }

    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers().stream().map(CustomerModel::new).collect(Collectors.toList());
    }


    public void deleteCustomer(String id) {
        customerService.deleteCustomer(id);

    }

    public ChangePasswordResponseModel changePassword(ChangePasswordModel changePasswordModel) {
        return customerServiceImpl.changePassword(changePasswordModel);
    }
}
