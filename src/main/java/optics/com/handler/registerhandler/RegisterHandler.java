package optics.com.handler.registerhandler;

import optics.com.model.registermodel.RegisterModel;
import optics.com.service.registerservice.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterHandler {
    @Autowired
    private RegisterServiceImpl registerServiceImpl;

    public void register(RegisterModel registerModel) throws Exception {
            registerServiceImpl.register(registerModel);

    }
}
