package optics.com.repository.confirmationtokenrepository;

import optics.com.domain.register.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken,String> {
}
