package optics.com.service.customerservice;

import optics.com.domain.customer.Customer;
import optics.com.repository.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository ;

    @Override
    public void save(Customer customer) {
     customerRepository.save(customer);

    }
}
