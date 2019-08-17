package optics.com.service.customerservice;

import optics.com.domain.customer.Customer;
import optics.com.model.CustomerModel;
import optics.com.repository.customerrepository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private  CustomerRepositoryImpl customerRepository ;

    public CustomerServiceImpl() {
        this.customerRepository = new CustomerRepositoryImpl();
    }


    @Override
    public void save(Customer customer) {
     customerRepository.save(customer);

    }
}
