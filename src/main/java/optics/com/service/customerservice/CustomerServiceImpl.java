package optics.com.service.customerservice;

import optics.com.domain.customer.Customer;
import optics.com.repository.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    Optional<Customer> dbUser;


    @Override
    public void save(Customer customer) {
        if(customerRepository.count()!=0) {
            if(customer.getId()!= null) {
                dbUser = customerRepository.findById(customer.getId());
                if (dbUser.isPresent()) {
                    customerRepository.save(customer);
                }
            }
            customerRepository.save(customer);
        }
        else {
            customerRepository.save(customer);
        }
        customerRepository.save(customer);

    }


}
