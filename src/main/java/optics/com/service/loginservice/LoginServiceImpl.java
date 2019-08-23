package optics.com.service.loginservice;

import optics.com.model.loginmodel.AuthenticationReponseModel;
import optics.com.model.loginmodel.LoginModel;
import optics.com.model.registermodel.RegisterModel;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl  implements  LoginService{


    @Autowired
    private RegiterRepository regiterRepository ;

    public AuthenticationReponseModel authenticate(LoginModel loginModel) throws Exception {
        for(RegisterModel customer : getcustomer()){
            if(loginModel.getUserName().equals(customer.getUserName())&& loginModel.getPassword().equals(customer.getPassword())){
                return new AuthenticationReponseModel(loginModel.getUserName(),true);
            }
            else {
                throw new Exception("invalid credentials");
            }
        }
        return null;

    }
    private Iterable<RegisterModel> getcustomer(){
      return regiterRepository.findAll();
    }
}
