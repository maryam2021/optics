package optics.com.repository.customerrepository;

import optics.com.domain.customer.Customer;
import optics.com.domain.register.Register;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Transactional
    @Modifying
    @Query("select c from customer c where c.customerShopName = ?1")
    List<Customer> getCustomerbyUsername(String userName);

    @Transactional
    @Query("select c from register c where c.email = ?1")
    Optional<Register> findByEmail(String username);


    @Transactional
    @Modifying
    @Query("select c from customer c where c.id = ?1")
    Customer updateCustomer(String id);

}
