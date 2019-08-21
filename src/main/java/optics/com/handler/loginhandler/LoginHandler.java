package optics.com.handler.loginhandler;


import optics.com.model.loginmodel.AuthenticationReponseModel;
import optics.com.model.loginmodel.LoginModel;
import optics.com.service.loginservice.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginHandler {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    public LoginHandler() {
        this.loginServiceImpl = new LoginServiceImpl();
    }

    public AuthenticationReponseModel authenticate(LoginModel loginModel) {
       return loginServiceImpl.authenticate(loginModel);
    }
}
