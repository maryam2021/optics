package optics.com.service.loginservice;

import optics.com.model.loginmodel.AuthenticationResponse;
import optics.com.model.loginmodel.LoginModel;

public interface LoginService {
    AuthenticationResponse authenticate(LoginModel loginModel) throws Exception;
}
