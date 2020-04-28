package optics.com.controller.customercontroller;


import optics.com.handler.changepassword.ChangePasswordHandler;
import optics.com.handler.customerhandler.CustomerHandler;
import optics.com.model.ChangePasswordResponseModel;
import optics.com.model.changepasswordmodel.ChangePasswordModel;
import optics.com.model.customermodel.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerHandler customerHandler;
    @Autowired
    private ChangePasswordHandler changePasswordHandler;


    @PostMapping(value = "/create-customer")
    public void save(@RequestBody CustomerModel customerModel) {
        customerHandler.save(customerModel);
    }

    @GetMapping(value = "/get-customer/{username}")
    public List<CustomerModel> getCustomers(@PathVariable("username") String userName) {
        return customerHandler.getCustomers(userName);
    }

    @GetMapping(value = "/get-customer")
    public List<CustomerModel> getAllCustomers() {
        return customerHandler.getAllCustomers();

    }


    @DeleteMapping(value = "/get-customer/{id}")
    public HttpStatus deleteCustomer(String id) {
        if(id !=null){
            customerHandler.deleteCustomer(id);
            return HttpStatus.OK;

        }
        else
            return  HttpStatus.BAD_REQUEST;

    }
    @PostMapping(value = "/forgot-password")
    public ChangePasswordResponseModel changePassword(@RequestBody  ChangePasswordModel changePasswordModel) {
        return changePasswordHandler.changePassword(changePasswordModel);
    }


}
