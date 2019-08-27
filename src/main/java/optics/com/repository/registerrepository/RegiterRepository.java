package optics.com.repository.registerrepository;

import optics.com.domain.register.Register;
import optics.com.model.registermodel.RegisterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegiterRepository extends CrudRepository<Register, String> {
}
