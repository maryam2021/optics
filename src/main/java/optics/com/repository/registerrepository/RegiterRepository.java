package optics.com.repository.registerrepository;

import optics.com.model.registermodel.RegisterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegiterRepository extends CrudRepository<RegisterModel, UUID> {
}
