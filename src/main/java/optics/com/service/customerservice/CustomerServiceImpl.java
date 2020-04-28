package optics.com.service.customerservice;

import optics.com.domain.customer.Customer;
import optics.com.domain.register.Register;
import optics.com.model.ChangePasswordResponseModel;
import optics.com.model.changepasswordmodel.ChangePasswordModel;
import optics.com.repository.customerrepository.CustomerRepository;
import optics.com.repository.registerrepository.RegiterRepository;
import optics.com.service.customerservice.customerconfig.CustomerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    Optional<Customer> dbUser;
    @Autowired
    RegiterRepository regiterRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerContext customerContext;
    @Autowired
    private JavaMailSender javaMailSender;
    //    @Autowired
//    private CustomerContext customerContext;

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
        return customerContext.getCurrentEmployee(false);
    }


    @Override
    public ChangePasswordResponseModel changePassword(ChangePasswordModel changePasswordModel) {
//
        return null;

    }

    public boolean isPasswordSame(ChangePasswordModel changePasswordModel, Optional<Register> loggedInEmployee) {
        // return passwordEncoder.matches(changePasswordModel.getOldPassword(), loggedInEmployee.getPassword());
        return true;
    }

}
