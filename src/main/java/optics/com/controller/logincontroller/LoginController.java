package optics.com.controller.logincontroller;


import optics.com.handler.loginhandler.LoginHandler;
import optics.com.model.loginmodel.AuthenticationReponseModel;
import optics.com.model.loginmodel.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginHandler loginHandler;

    @PostMapping(value = "/login")
    public AuthenticationReponseModel authenticate(@RequestBody LoginModel loginModel) throws Exception {
       return loginHandler.authenticate(loginModel);
    }

}
