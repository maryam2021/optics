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
        for(RegisterModel users : getRegisterUser()){
            if(loginModel.getUserName().equals(users.getUserName())&& loginModel.getPassword().equals(users.getPassword())){
                return new AuthenticationReponseModel(loginModel.getUserName(),true);
            }
            else {
                throw new Exception("invalid credentials");
            }
        }
        return null;

    }
    private Iterable<RegisterModel> getRegisterUser(){
      return regiterRepository.findAll();
    }
}
