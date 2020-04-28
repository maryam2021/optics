package optics.com.service.loginservice;

import optics.com.model.loginmodel.AuthenticationReponse;
import optics.com.model.loginmodel.LoginModel;

public interface LoginService {
    AuthenticationReponse authenticate(LoginModel loginModel) throws Exception;
}
