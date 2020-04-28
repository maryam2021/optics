package optics.com.service.customerservice;

import optics.com.domain.customer.Customer;
import optics.com.domain.register.Register;
import optics.com.repository.customerrepository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
//    @Autowired
//    private CustomerContext customerContext;
    Optional<Customer> dbUser;


    @Override
    public void save(Customer customer) {
        if (customerRepository.count() != 0) {
            if (customer.getId() != null) {
                dbUser = customerRepository.findById(customer.getId());
                if (dbUser.isPresent()) {
                    Optional<Register> user = getLoggedInUser();
                    customer.setCustomerShopName(user.get().getUserName());
                    customerRepository.save(customer);
                }
            }
            customerRepository.save(customer);
        } else {
            customerRepository.save(customer);
        }
        customerRepository.save(customer);

    }

    @Override
    public List<Customer> getCustomer(String userName) {
        return customerRepository.getCustomerbyUsername(userName);

    }


    @Override
    public Optional<Register> findByEmail(String username) {
        return customerRepository.findByEmail(username);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }


    private Optional<Register> getLoggedInUser() {
        return null;
      //  return customerContext.getCurrentEmployee(false);
    }

}
