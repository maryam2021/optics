package optics.com.service.loginservice;

import optics.com.model.loginmodel.AuthenticationReponseModel;
import optics.com.model.loginmodel.LoginModel;

public interface LoginService {
    AuthenticationReponseModel authenticate(LoginModel loginModel) throws Exception;
}
