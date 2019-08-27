package optics.com.repository.customerrepository;

import optics.com.domain.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
