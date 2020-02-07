package optics.com.controller.customercontroller;


import optics.com.handler.customerhandler.CustomerHandler;
import optics.com.model.customermodel.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerHandler customerHandler;

    @PostMapping(value = "/save")
    public void save(@RequestBody CustomerModel customerModel) {
        customerHandler.save(customerModel);
    }


}