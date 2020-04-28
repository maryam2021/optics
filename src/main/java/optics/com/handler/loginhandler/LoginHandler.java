package optics.com.handler.loginhandler;


import optics.com.model.loginmodel.AuthenticationResponse;
import optics.com.model.loginmodel.LoginModel;
import optics.com.service.loginservice.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginHandler {

    @Autowired
    private LoginServiceImpl loginServiceImpl;


    public AuthenticationResponse authenticate(LoginModel loginModel) throws Exception {
       return loginServiceImpl.authenticate(loginModel);
    }
}
