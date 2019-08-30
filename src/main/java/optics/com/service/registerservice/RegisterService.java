package optics.com.service.registerservice;

import optics.com.domain.register.Register;
import optics.com.model.registermodel.RegisterModel;

public interface RegisterService {
    void register(Register register) throws Exception;

    void confirmUserAccount(String confirmationToken) throws Exception;
}
