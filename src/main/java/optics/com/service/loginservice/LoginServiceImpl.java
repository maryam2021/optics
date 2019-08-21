package optics.com.service.loginservice;

import optics.com.model.loginmodel.AuthenticationReponseModel;
import optics.com.model.loginmodel.LoginModel;
import optics.com.repository.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl  implements  LoginService{


    @Autowired
    private CustomerRepository customerRepository ;

    public AuthenticationReponseModel authenticate(LoginModel loginModel) {
        return null;

    }
}
