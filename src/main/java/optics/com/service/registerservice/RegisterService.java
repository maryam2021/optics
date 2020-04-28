package optics.com.service.registerservice;

import optics.com.domain.register.Register;
import optics.com.model.registermodel.RegisterModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RegisterService {
    void register(Register register) throws Exception;

    void confirmUserAccount(String confirmationToken) throws Exception;

    Register findByUsername (String userName);


}
