package optics.com.service.customerservice;

import optics.com.domain.customer.Customer;
import optics.com.domain.register.Register;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void save(Customer customer);

    List<Customer> getCustomer(String userName);

    Optional<Register> findByEmail(String username);

    List<Customer> getAllCustomers();

    void deleteCustomer(String id);
}
