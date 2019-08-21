package optics.com.controller.registercontroller;

import optics.com.handler.registerhandler.RegisterHandler;
import optics.com.model.registermodel.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private RegisterHandler registerHandler;


    @PostMapping(value = "/register")
    public void register(@RequestBody RegisterModel registerModel) throws Exception {
        registerHandler.register(registerModel);
    }
}
