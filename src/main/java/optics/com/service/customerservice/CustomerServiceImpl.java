package optics.com.service.customerservice;

import optics.com.domain.customer.Customer;
import optics.com.repository.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    Iterable<Customer> dbUser;


    @Override
    public void save(Customer customer) {
        if(customerRepository.count() != 0){
        dbUser = customerRepository.findAll();
        for (Customer customers : dbUser) {
            if (customers.getId().equals(customer.getId())) {
                customerRepository.save(customer);
            }
        }
        }
        customerRepository.save(customer);

    }


}
